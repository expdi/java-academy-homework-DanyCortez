package com.track.musictrack.services;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;
import com.track.musictrack.dao.TrackDAO;
import com.track.musictrack.enums.MediaType;
import com.track.musictrack.provider.NetworkPriceProvider;
import com.track.musictrack.services.interfaces.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TrackService implements ITrackService {

    @Autowired
    private TrackDAO trackDAO;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private NetworkPriceProvider networkPriceProvider;

    private AtomicInteger nextId = new AtomicInteger(1);

    public Track create(Track track) {
        int newId = nextId.getAndIncrement();
        track.setId(newId);
        return this.trackDAO.create(track);
    }

    public boolean update(Track track) {
        return this.trackDAO.update(track);
    }

    public boolean delete(int id) {
        return this.trackDAO.delete(id);
    }

    public Track getById(int id) {

        Track trackById = this.trackDAO.getById(id);

        if(trackById != null) {
            networkPriceProvider.addPriceToTrack(trackById);
        }


        return trackById;
    }
    public List<Track> getAll() {

        List<Track> tracks = this.trackDAO.getAll();

        tracks.forEach(track -> networkPriceProvider.addPriceToTrack(track));

        return tracks;
    }
    public List<Track> getAllByMediaType(MediaType mediaType) {
        List<Track> tracks = this.trackDAO.getAllByMediaType(mediaType);

        tracks.forEach(track -> networkPriceProvider.addPriceToTrack(track));

        return tracks;
    }
    public List<Track> getAllByYear(int year) {
        List<Track> tracks = this.trackDAO.getAllByYear(year);

        tracks.forEach(track -> networkPriceProvider.addPriceToTrack(track));

        return tracks;
    }
    public Track getByLongestDuration() {
       Track track = this.trackDAO.getByLongestDuration();
        networkPriceProvider.addPriceToTrack(track);

        return track;
    }
    public Track getByShortestDuration() {
        Track track = this.trackDAO.getByShortestDuration();

        if(track != null) {
            networkPriceProvider.addPriceToTrack(track);
        }

        return track;
    }
    public List<Track> getBySpecificDuration(int duration) {
        List<Track> tracks = this.trackDAO.getBySpecificDuration(duration);
        tracks.forEach(track -> networkPriceProvider.addPriceToTrack(track));

        return tracks;
    }

    public List<Track> getByArtistName(String name) {

        Artist artist = artistService.getByName(name);

        List<Track> tracks = this.trackDAO.getAll();

        List<Track> tracksFilter = tracks.stream()
                .filter(track -> track.getIdsArtistRelated() != null &&  track.getIdsArtistRelated().length > 0 && verifyIfContainsIdForSearch(track.getIdsArtistRelated(), artist.getId()) )
                .collect(Collectors.toList());

        tracksFilter.forEach(track -> networkPriceProvider.addPriceToTrack(track));

        return tracksFilter;
    };

    private static boolean verifyIfContainsIdForSearch(int[] idsTracks, int idForSearch) {
        for (int id : idsTracks) {
            if(id == idForSearch) {
                return true;
            }
        }
        return false;
    }

}

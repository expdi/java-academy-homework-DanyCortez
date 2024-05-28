package com.track.musictrack.services;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;
import com.track.musictrack.dao.ArtistDAO;
import com.track.musictrack.provider.NetworkPriceProvider;
import com.track.musictrack.services.interfaces.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ArtistService implements IArtistService {

    @Autowired
    private ArtistDAO artistDAO;

    @Autowired
    private TrackService trackService;

    @Autowired
    private NetworkPriceProvider networkPriceProvider;
    private AtomicInteger nextId = new AtomicInteger(1);

    public Artist create(Artist artist) {
        int newId = nextId.getAndIncrement();
        artist.setId(newId);
        return this.artistDAO.create(artist);
    }

    public boolean update(Artist artist) {
        return this.artistDAO.update(artist);
    }

    public boolean delete(int id) {
        return this.artistDAO.delete(id);
    }

    public Artist getById(int id) {
        return this.artistDAO.getById(id);
    }

    public List<Artist> getAll() {
        return this.artistDAO.getAll();
    }
    public Artist getByName(String nickName) { return this.artistDAO.getByName(nickName); }

    public List<Track> getByArtistName(String nickName) {

        Artist artist = this.artistDAO.getByName(nickName);

        List<Track> tracks = this.trackService.getAll();

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

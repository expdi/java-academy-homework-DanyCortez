package com.track.musictrack.dao;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;
import com.track.musictrack.dao.interfaces.ITrackDAO;
import com.track.musictrack.enums.MediaType;
import com.track.musictrack.services.ArtistService;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class TrackDAO implements ITrackDAO {
    private Map<Integer, Track> tracks;

    TrackDAO() {
        tracks = new HashMap<>();
    }

    @Override
    public Track getById(int id) {
        return this.tracks.get(id);
    }

    @Override
    public Track create(Track track) {
        this.tracks.put(track.getId(), track);
        return track;
    }

    @Override
    public boolean update(Track track) {
        return this.tracks.replace(track.getId(), track) != null;
    }

    @Override
    public boolean delete(int id) {

        return this.tracks.remove(id) != null;
    };

    @Override
    public List<Track> getAll() {

       return new ArrayList<>(this.tracks.values());
    };

    @Override
    public List<Track> getAllByMediaType(MediaType mediaType) {
        return this.tracks.values().stream()
                .filter(track -> track.getMediaType() == mediaType)
                .collect(Collectors.toList());
    }

    @Override
    public List<Track> getAllByYear(int year) {
        return this.tracks.values().stream()
                .filter(track -> track.getIssueDate().getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public Track getByLongestDuration() {

        return  this.tracks.values().stream().max((o1, o2) -> Integer.compare(o1.getDurationSeconds(), o2.getDurationSeconds())).orElse(null);
    };

    @Override
    public Track getByShortestDuration() {

        return this.tracks.values().stream().min((o1, o2) -> Integer.compare(o1.getDurationSeconds(), o2.getDurationSeconds())).orElse(null);
    };

    @Override
    public List<Track> getBySpecificDuration(int duration) {

        return this.tracks.values().stream()
                .filter(track -> track.getDurationSeconds() == duration )
                .collect(Collectors.toList());
    };



}

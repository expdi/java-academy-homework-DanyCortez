package com.track.musictrack.services.interfaces;

import com.track.musictrack.classes.Track;
import com.track.musictrack.enums.MediaType;

import java.util.List;

public interface ITrackService {
    Track create(Track track);
    boolean update(Track track);
    boolean delete(int id);
    Track getById(int id);
    List<Track> getAllByMediaType(MediaType mediaType);
    List<Track> getAllByYear(int year);
    Track getByLongestDuration();
    Track getByShortestDuration();
    List<Track> getBySpecificDuration(int duration);
    List<Track> getByArtistName(String name);
}

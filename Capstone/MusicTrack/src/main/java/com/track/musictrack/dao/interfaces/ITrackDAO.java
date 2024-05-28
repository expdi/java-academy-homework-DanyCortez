package com.track.musictrack.dao.interfaces;

import com.track.musictrack.classes.Track;
import com.track.musictrack.enums.MediaType;

import java.util.List;

public interface ITrackDAO {
    Track create(Track track);
    boolean update(Track track);
    boolean delete(int id);
    Track getById(int id);

    List<Track> getAll();
    List<Track> getAllByMediaType(MediaType mediaType);
    List<Track> getAllByYear(int year);
    //List<Track> getAllByArtist(String name);
    Track getByLongestDuration();
    Track getByShortestDuration();
    List<Track> getBySpecificDuration(int durationSeconds);
}

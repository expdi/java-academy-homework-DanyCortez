package com.track.musictrack.services.interfaces;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;

import java.util.List;

public interface IArtistService {
    Artist create(Artist track);
    boolean update(Artist track);
    boolean delete(int id);
    Artist getById(int id);
    Artist getByName(String nickName);
    List<Track> getByArtistName(String name);
}

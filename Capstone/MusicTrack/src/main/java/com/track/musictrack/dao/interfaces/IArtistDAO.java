package com.track.musictrack.dao.interfaces;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;

import java.util.List;

public interface IArtistDAO {
    Artist create(Artist track);
    boolean update(Artist track);
    boolean delete(int id);
    Artist getById(int id);
    Artist getByName(String name);
    //List<Track> getTracks(int id);
    List<Artist> getAll();
}

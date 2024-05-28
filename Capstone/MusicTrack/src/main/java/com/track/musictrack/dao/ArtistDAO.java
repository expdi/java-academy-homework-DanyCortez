package com.track.musictrack.dao;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;
import com.track.musictrack.dao.interfaces.IArtistDAO;
import com.track.musictrack.dao.interfaces.ITrackDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ArtistDAO implements IArtistDAO {
    private Map<Integer, Artist> artists;

    ArtistDAO() {
        artists = new HashMap<>();
    }

    @Override
    public Artist getById(int id) {
        return this.artists.get(id);
    }

    @Override
    public Artist create(Artist artist) {
        this.artists.put(artist.getId(), artist);
        return artist;
    }

    @Override
    public boolean update(Artist artist) {
        return this.artists.replace(artist.getId(), artist) != null;
    }

    @Override
    public Artist getByName(String nickName) {
        return this.artists.values().stream()
                .filter(artist -> artist.getNickName().contains(nickName))
                .findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {

        return this.artists.remove(id) != null;
    };

    @Override
    public List<Artist> getAll() {

        return new ArrayList<>(this.artists.values());
    };
}

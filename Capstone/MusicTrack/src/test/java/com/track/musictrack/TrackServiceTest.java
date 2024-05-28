package com.track.musictrack;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;
import com.track.musictrack.enums.MediaType;
import com.track.musictrack.services.ArtistService;
import com.track.musictrack.services.TrackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrackServiceTest {

    @Autowired
    private TrackService trackservice;

    @Autowired
    private ArtistService artistService;

    @Test
    public void getAll() {
        List<Track> tracks = trackservice.getAll();
        tracks.forEach(System.out::println);
        assertEquals(4, tracks.size());

    }

    @Test
    public void getById() {

        Track track = trackservice.getById(2);
        assertNotNull(track);
    }

    @Test
    public void notFoundById() {

        Track track = trackservice.getById(1000);
        assertNull(track);
    }


    @Test
    public void trackCreatedCorrectly() {
        Track trackCreated = trackservice.create(new Track("Desconocidos", "Unkonw", LocalDate.now(), 120, MediaType.MP3));

        assertNotNull(trackCreated);
    }

    @Test
    public void trackUpdateCorrectly() {

        Track trackForModify = new Track(1, "Olvidados", "Olvidado", LocalDate.now(), 120, MediaType.MP3);

        trackservice.update(trackForModify);

        Track trackModified = trackservice.getById(1);

        assertEquals("Olvidados", trackModified.getTitle());
    }

    @Test
    public void getByCorrectMediaType() {
        List<Track> track = trackservice.getAllByMediaType(MediaType.OGG);
        assertNotNull(track);
    }

    @Test
    public void getByCorrectYear() {
        List<Track> track = trackservice.getAllByYear(2024);
        assertNotNull(track);
    }

    @Test
    public void getLongesDuration() {
        Track track = trackservice.getByLongestDuration();
        assertEquals("Desconocidos", track.getTitle());
    }

    @Test
    public void getShortestDuration() {

        Track track = trackservice.getByShortestDuration();
        assertEquals("Olvidados", track.getTitle());
    }

    @Test
    public void getBySpecificDuration() {

        List<Track> tracksBySpecificDuration = trackservice.getBySpecificDuration(140);
        assertEquals(1, tracksBySpecificDuration.size());
    }

    @Test
    public void getTracksByArtistName() {

        List<Track> tracks = trackservice.getAll();
        List<Artist> artists = artistService.getAll();

        tracks.forEach(System.out::println);
        artists.forEach(System.out::println);

        List<Track> tracksByArtist = trackservice.getByArtistName("Melina");
        assertEquals(1, tracksByArtist.size());
    }
}

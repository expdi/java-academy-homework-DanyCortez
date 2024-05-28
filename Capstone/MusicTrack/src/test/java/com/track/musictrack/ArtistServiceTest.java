package com.track.musictrack;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;
import com.track.musictrack.enums.MediaType;
import com.track.musictrack.services.ArtistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ArtistServiceTest {
    @Autowired
    private ArtistService artistService;

    @Test
    public void getAll() {
        List<Artist> artists = artistService.getAll();
        assertEquals(3, artists.size());
        artists.forEach(System.out::println);
    }

    @Test
    public void getById() {

        Artist artist = artistService.getById(2);
        assertNotNull(artist);
    }

    @Test
    public void notFoundById() {

        Artist artist = artistService.getById(3);
        assertNull(artist);
    }


    @Test
    public void trackCreatedCorrectly() {
        Artist artistCreated = artistService.create(new Artist("Melina", "Guzman", LocalDate.now().plusYears(-20)));
        assertNotNull(artistCreated);
    }

    @Test
    public void trackUpdateCorrectly() {

        Artist artistForModify = new Artist(1, "Paty", "Cantu", LocalDate.now().plusYears(-40));

        artistService.update(artistForModify);

        Artist artistModified = artistService.getById(1);

        assertEquals("Paty", artistModified.getNickName());
    }

    @Test
    public void getByName() {

        Artist artist = artistService.getByName("Melina");
        assertNotNull(artist);
    }
}

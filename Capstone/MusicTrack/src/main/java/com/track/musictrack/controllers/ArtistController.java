package com.track.musictrack.controllers;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;
import com.track.musictrack.services.ArtistService;
import com.track.musictrack.services.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Artist> artists = artistService.getAll();
        return ResponseEntity.ok(artists);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Artist artist) {
        Artist artistCreated = artistService.create(artist);
        return ResponseEntity.ok(artistCreated);
    }

    @PutMapping
    public ResponseEntity<?> update(Artist artist) {
        boolean wasUpdated = artistService.update(artist);

        if(wasUpdated) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Was Updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No artist found for update with id: " + artist.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        boolean wasDeleted = artistService.delete(id);

        if(wasDeleted) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Was Deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No artist found for delete with id: " + id);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Artist artist = artistService.getById(id);

        if(artist != null) {
            return ResponseEntity.ok(artist);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track found with id: " + id);
    }

    @GetMapping(path = "/getByArtistName/{name}")
    public ResponseEntity<?> getBySpecificDuration(@PathVariable String name) {
        List<Track> tracks = artistService.getByArtistName(name);

        return ResponseEntity.ok(tracks);
    }
}

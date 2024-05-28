package com.track.musictrack.controllers;

import com.track.musictrack.classes.Track;
import com.track.musictrack.enums.MediaType;
import com.track.musictrack.services.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Track> tracks = trackService.getAll();
        return ResponseEntity.ok(tracks);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Track track) {
        Track trackCreated = trackService.create(track);
        return ResponseEntity.status(HttpStatus.CREATED).body("Was Created");
    }

    @PutMapping
    public ResponseEntity<?> update(Track track) {
        boolean wasUpdated = trackService.update(track);

        if(wasUpdated) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Was Updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track found for update with id: " + track.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        boolean wasDeleted = trackService.delete(id);

        if(wasDeleted) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Was Deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track found for delete with id: " + id);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Track adopter = trackService.getById(id);

        if(adopter != null) {
            return ResponseEntity.ok(adopter);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track found with id: " + id);
    }

    @GetMapping(path = "/getAllByMediaType/{mediaType}")
    public ResponseEntity<?> getAllByMediaType(@PathVariable MediaType mediaType) {
        List<Track> tracks = trackService.getAllByMediaType(mediaType);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tracks);
    }

    @GetMapping(path = "/getAllByYear/{year}")
    public ResponseEntity<?> getAllByYear(@PathVariable int year) {
        List<Track> tracks = trackService.getAllByYear(year);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tracks);
    }

    @GetMapping(path = "/getByLongestDuration")
    public ResponseEntity<?> getAllByYeargetByLongestDuration() {
        Track track = trackService.getByLongestDuration();

        if(track != null) {
            return ResponseEntity.ok(track);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track found");
    }

    @GetMapping(path = "/getByShortestDuration")
    public ResponseEntity<?> getByShortestDuration() {
        Track track = trackService.getByShortestDuration();

        if(track != null) {
            return ResponseEntity.ok(track);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track found");
    }

    @GetMapping(path = "/getBySpecificDuration/{durationSeconds}")
    public ResponseEntity<?> getBySpecificDuration(@PathVariable int durationSeconds) {
        List<Track> tracks = trackService.getBySpecificDuration(durationSeconds);

        return ResponseEntity.ok(tracks);
    }

    @GetMapping(path = "/getByArtistName/{name}")
    public ResponseEntity<?> getBySpecificDuration(@PathVariable String name) {
        List<Track> tracks = trackService.getByArtistName(name);

        return ResponseEntity.ok(tracks);
    }
}

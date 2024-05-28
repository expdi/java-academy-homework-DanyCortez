package com.track.musictrack;

import com.track.musictrack.classes.Artist;
import com.track.musictrack.classes.Track;
import com.track.musictrack.enums.MediaType;
import com.track.musictrack.services.ArtistService;
import com.track.musictrack.services.TrackService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@SpringBootApplication
public class MusicTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicTrackApplication.class, args);
    }
}

@Component
class MyRunner implements CommandLineRunner {

    final TrackService trackService;
    private ArtistService artistService;

    public MyRunner(TrackService trackService, ArtistService artistService){
        this.trackService = trackService;
        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {
        artistService.create(new Artist("Melina", "Guzman", LocalDate.now().plusYears(-20), "Melina"));
        artistService.create(new Artist("Paty", "Cantu", LocalDate.now().plusYears(-40), "PatyCantu"));
        artistService.create(new Artist("Alex", "Bec", LocalDate.now().plusYears(-45), "AlexBec"));

        trackService.create(new Track("Desconocidos", "Unkonw", LocalDate.now(), 140, MediaType.MP3, new int[] {1}));
        trackService.create(new Track("Olvidados", "Olvid", LocalDate.now().plusYears(2), 120, MediaType.OGG, new int[] {2}));
        trackService.create(new Track("Desconocidos", "Unkonw", LocalDate.now(), 145, MediaType.OGG, new int[] {2}));
        trackService.create(new Track("Desesperados", "Deseperado", LocalDate.now().plusYears(2), 120, MediaType.WAV, new int[] {2}));

        System.out.println("Executing runner");
        System.out.println("================GET ALL METHOD=====================");
        trackService.getAll().forEach(System.out::println);
        System.out.println();

    }
}

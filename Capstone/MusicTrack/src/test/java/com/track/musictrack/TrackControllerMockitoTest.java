package com.track.musictrack;

import com.track.musictrack.classes.Track;
import com.track.musictrack.controllers.TrackController;
import com.track.musictrack.enums.MediaType;
import com.track.musictrack.services.TrackService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TrackControllerMockitoTest {
    @Mock
    private TrackService trackService;

    @InjectMocks
    private TrackController trackController;

    private List<Track> tracks = List.of(
            new Track("Desconocidos", "Unkonw", LocalDate.now(), 120, MediaType.MP3, 0),
            new Track("Olvidados", "Olvidados", LocalDate.now(), 180, MediaType.OGG, 0),
            new Track("Desesperados", "Desperados", LocalDate.now(), 120, MediaType.WAV, 0));

    @Test
    public void getAll() {
        Mockito.when(trackService.getAll()).thenReturn(tracks);


        ResponseEntity<?> result = trackController.getAll();

        assertEquals(HttpStatus.OK, result.getStatusCode());

        Mockito.verify(trackService).getAll();
    }

    @Test
    public void getOneWithGoodId() {
        Mockito.when(trackService.getById(1)).thenReturn(tracks.get(0));

        ResponseEntity<?> result = trackController.getById(1);

        assertEquals(HttpStatus.OK, result.getStatusCode());

        Mockito.verify(trackService).getById(1);
    }

    @Test
    public void getOneWithBadId() {
        Mockito.when(trackService.getById(1000)).thenReturn(null);

        ResponseEntity<?> result = trackController.getById(1000);

        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

        Mockito.verify(trackService).getById(1000);
    }

    @Test
    public void createCorrectly() throws URISyntaxException {
        Track track = new Track("Remember", "Remeber", LocalDate.now(), 120, MediaType.MP3);
        track.setId(4);

        Mockito.when(trackService.create(track))
                .thenReturn(track);

        ResponseEntity<?> result = trackController.add(track);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        Mockito.verify(trackService).create(track);
    }

    @Test
    public void updateCorrectly() {
        Mockito.when(trackService.update(tracks.get(0))).thenReturn(true);

        ResponseEntity<?> result = trackController.update(tracks.get(0));

        assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());

        Mockito.verify(trackService).update(tracks.get(0));
    }

    @Test
    public void deleteAdopterWithGoodId() {
        Mockito.when(trackService.delete(1)).thenReturn(true);

        ResponseEntity<?> result = trackController.delete(1);

        assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());

        Mockito.verify(trackService).delete(1);
    }

    @Test
    public void getAllByMediaType() {
        List<Track> tracksForResult = List.of(
                new Track("Desconocidos", "Unkonw", LocalDate.now(), 120, MediaType.MP3, 0));

        Mockito.when(trackService.getAllByMediaType(MediaType.MP3)).thenReturn(tracksForResult);

        ResponseEntity<?> result = trackController.getAllByMediaType(MediaType.MP3);

        assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());

        Mockito.verify(trackService).getAllByMediaType(MediaType.MP3);
    }

}

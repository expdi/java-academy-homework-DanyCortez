package com.track.musictrack.classes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import com.track.musictrack.enums.MediaType;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Track {
   int id;

   @JsonProperty("title")
   String title;

   @JsonProperty("album")
   String album;

   @JsonProperty("issueDate")
   LocalDate issueDate;

   @JsonProperty("durationSeconds")
   int durationSeconds;

   @JsonProperty("mediaType")
   MediaType mediaType;

   @JsonProperty("price")
   int price;

   @JsonProperty("idsArtistRelated")
   int[] idsArtistRelated;

   public Track(String title, String album, LocalDate issueDate, int durationSeconds, MediaType mediaType, int price, int[] idsArtistRelated) {
        this.title = title;
        this.album = album;
        this.issueDate = issueDate;
        this.durationSeconds = durationSeconds;
        this.mediaType = mediaType;
        this.price = price;
        this.idsArtistRelated = idsArtistRelated;
   }

    public Track(String title, String album, LocalDate issueDate, int durationSeconds, MediaType mediaType, int price) {
        this(title, album,  issueDate, durationSeconds, mediaType, price, null);
    }

    public Track(String title, String album, LocalDate issueDate, int durationSeconds, MediaType mediaType) {
        this(title, album, issueDate, durationSeconds, mediaType, 0);
    }

    public Track(int id, String title, String album, LocalDate issueDate, int durationSeconds, MediaType mediaType) {
        this(id, title, album, issueDate, durationSeconds, mediaType, 0, null);
    }

    public Track(String title, String album, LocalDate issueDate) {
       this(title, album, issueDate, 0, MediaType.OGG, 0);
    }

    public Track(String title, String album, LocalDate issueDate, int durationSeconds, MediaType mediaType, int[] idsArtistRelated) {
        this(title, album, issueDate, durationSeconds, mediaType, 0, idsArtistRelated);
    }
}

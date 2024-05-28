package com.track.musictrack.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Artist {
    int id;
    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("Birthday")
    LocalDate birthday;

    @JsonProperty("genre")
    String[] genre;

    @JsonProperty("nickName")
    String nickName;

    public Artist(String firstName, String lastName, LocalDate birthday, String[] genre, String nickName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.genre = genre;
        this.nickName = nickName;
    }

    public Artist(String firstName, String lastName, LocalDate birthday, String[] genre) {
        this(firstName, lastName, birthday, genre, "");
    }

    public Artist(String firstName, String lastName, LocalDate birthday, String nickName) {
        this(firstName, lastName, birthday, null, nickName);
    }

    public Artist(String firstName, String lastName, LocalDate birthday) {
        this(firstName, lastName, birthday, null, "");
    }

    public Artist(String firstName, String lastName) {
        this(firstName, lastName, LocalDate.now(), null, "");
    }

    public Artist(int id, String firstName, String lastName, LocalDate birthday) {
        this(id, firstName, lastName, birthday, null, "");
    }
}

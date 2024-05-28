package com.example.javasessionhomeworkjpa.clases;

import com.example.javasessionhomeworkjpa.enums.Breed;
import com.example.javasessionhomeworkjpa.enums.PetType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id", nullable = false)
    private int id;
    private LocalDate adoption_date;

    @Enumerated(EnumType.STRING)
    private PetType pet_type;
    private String name;
    @Enumerated(EnumType.STRING)
    private Breed breed_type;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "adopter_id")
    private Adopter adopter;

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {

    }
}

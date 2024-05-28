package com.example.javasessionhomeworkjpa.clases;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Adopter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adopter_id", nullable = false)
    private Integer id;
    private String name;

    private long phone_number;
    @OneToMany(mappedBy = "adopter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pet> pets = new ArrayList<>();

    public Adopter() {

    }
}
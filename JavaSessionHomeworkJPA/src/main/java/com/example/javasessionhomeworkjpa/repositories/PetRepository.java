package com.example.javasessionhomeworkjpa.repositories;

import com.example.javasessionhomeworkjpa.clases.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}

package com.example.javasessionhomeworkjpa.repositories;


import com.example.javasessionhomeworkjpa.clases.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Long> {
    @Query("SELECT a FROM Adopter a LEFT JOIN FETCH a.pets WHERE a.name like %:name%")
    List<Adopter> findAdopterByName(String name);

    @Query("SELECT a FROM Adopter a LEFT JOIN FETCH a.pets p WHERE p IS NOT NULL")
    List<Adopter> findAdopterWithPets();

    @Query("SELECT a FROM Adopter a LEFT JOIN FETCH a.pets p WHERE p IS NULL")
    List<Adopter> findAdopterWithoutPets();

}

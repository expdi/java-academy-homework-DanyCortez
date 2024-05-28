package com.example.javasessionhomeworkjpa.controllers;

import com.example.javasessionhomeworkjpa.clases.Pet;
import com.example.javasessionhomeworkjpa.service.AdopterService;
import com.example.javasessionhomeworkjpa.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    @GetMapping
    public ResponseEntity<?> getPets() {
        List<Pet> adopter = petService.getAllPets();
        return ResponseEntity.ok(adopter);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<?> getPetById(@PathVariable int petId) {
        Pet adopter = petService.getPetById((long)petId);
        return ResponseEntity.ok(adopter);
    }

    @PostMapping
    public ResponseEntity<?> addPet(@RequestBody Pet pet) {
        Pet createdPet = petService.addPet(pet);

        return ResponseEntity.ok(createdPet);
    }

    @PutMapping
    public ResponseEntity<?> updatePet(@RequestBody Pet pet) {
        Pet updatedAdopter = petService.updatePet(pet);
        return ResponseEntity.ok(updatedAdopter);
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<?> deletePet(@PathVariable Integer petId) {
        petService.deletePet((long) petId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResponse notFound(NoSuchElementException ex) {
        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    }

}

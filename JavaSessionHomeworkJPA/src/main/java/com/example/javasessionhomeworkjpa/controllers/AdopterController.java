package com.example.javasessionhomeworkjpa.controllers;

import com.example.javasessionhomeworkjpa.clases.Adopter;
import com.example.javasessionhomeworkjpa.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/adopters")
public class AdopterController {

    @Autowired
    private AdopterService adopterService;

    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping
    public ResponseEntity<?> getAdopters() {
        List<Adopter> adopter = adopterService.getAll();
        return ResponseEntity.ok(adopter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdopterById(@PathVariable int id) {
        Adopter adopter = adopterService.findAdopterById((long) id);
        return ResponseEntity.ok(adopter);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        List<Adopter> adopter = adopterService.findAdopterByName(name);
        return ResponseEntity.ok(adopter);
    }

    @GetMapping("/getAllWithPets")
    public ResponseEntity<?> getAdopterWithPets() {
        List<Adopter> adopter = adopterService.findAdopterWithPets();
        return ResponseEntity.ok(adopter);
    }

    @GetMapping("/getAllWithoutPets")
    public ResponseEntity<?> getAdopterWithoutPets() {
        List<Adopter> adopter = adopterService.findAdopterWithoutPets();
        return ResponseEntity.ok(adopter);
    }

    @PostMapping
    public ResponseEntity<?> addAdopter(@RequestBody Adopter adopter) {

        try {
            Adopter adopterCreated = adopterService.addAdopterWithPets(adopter);

            return ResponseEntity.ok(adopterCreated);
        }
            catch(Exception ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            }

    }

    @PutMapping("/{adopterId}")
    public ResponseEntity<?> updateAdopter(@PathVariable Integer adopterId, @RequestBody Adopter adopter) {
        Adopter updatedAdopter = adopterService.updateAdopter((long) adopterId, adopter);
        return ResponseEntity.ok(updatedAdopter);
    }

    @DeleteMapping("/{adopterId}")
    public ResponseEntity<?> deleteAdopter(@PathVariable Integer adopterId) {
        adopterService.deleteAdopter((long) adopterId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResponse notFound(NoSuchElementException ex) {
        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    }
}

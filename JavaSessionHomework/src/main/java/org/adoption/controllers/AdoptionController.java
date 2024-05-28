package org.adoption.controllers;

import org.adoption.classes.Adopter;
import org.adoption.services.AdoptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/adopters")
public class AdoptionController {

    private final AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Adopter> adopters = adoptionService.getAll();
        return ResponseEntity.ok(adopters);
    }

    @GetMapping("/getTest")
    public ResponseEntity<?> getTest() {
        String mensaje  = adoptionService.helloWorld();
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Adopter adopter) {
        Adopter newAdopter = adoptionService.add(adopter);
        return ResponseEntity.ok(newAdopter.getName());
    }

    @PutMapping
    public ResponseEntity<?> update(Adopter adopter) {
        boolean wasUpdated = adoptionService.update(adopter);

        if(wasUpdated) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Was Updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopter found for update with id: " + adopter.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        boolean wasDeleted = adoptionService.delete(id);

        if(wasDeleted) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Was Deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopter found for delete with id: " + id);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Adopter adopter = adoptionService.getById(id);

        if(adopter != null) {
            return ResponseEntity.ok(adopter);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopter found with id: " + id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResponse notFound(NoSuchElementException ex) {
        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    }
}

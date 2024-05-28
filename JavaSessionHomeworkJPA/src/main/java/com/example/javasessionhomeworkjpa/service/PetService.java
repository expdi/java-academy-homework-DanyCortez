package com.example.javasessionhomeworkjpa.service;

import com.example.javasessionhomeworkjpa.clases.Pet;
import com.example.javasessionhomeworkjpa.interfaces.IPetService;
import com.example.javasessionhomeworkjpa.repositories.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService implements IPetService {

    @Autowired
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet getPetById(Long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found with id: " + petId));
    }

    @Override
    public Pet updatePet(Pet updatePet) {
        return petRepository.save(updatePet);
    }

    @Override
    public void deletePet(Long petId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found with id: " + petId));

        petRepository.delete(pet);
    }
}

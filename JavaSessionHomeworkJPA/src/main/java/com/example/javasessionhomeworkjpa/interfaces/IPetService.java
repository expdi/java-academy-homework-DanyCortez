package com.example.javasessionhomeworkjpa.interfaces;

import com.example.javasessionhomeworkjpa.clases.Pet;

import java.util.List;

public interface IPetService {

    public List<Pet> getAllPets();
    public Pet addPet(Pet pet);

    public Pet getPetById(Long petId);
    public Pet updatePet(Pet updatePet);
    public void deletePet(Long petId);
}

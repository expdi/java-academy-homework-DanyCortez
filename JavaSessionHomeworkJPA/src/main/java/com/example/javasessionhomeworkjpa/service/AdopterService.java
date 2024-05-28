package com.example.javasessionhomeworkjpa.service;

import com.example.javasessionhomeworkjpa.clases.Adopter;
import com.example.javasessionhomeworkjpa.interfaces.IAdopterService;
import com.example.javasessionhomeworkjpa.repositories.AdopterRepository;
import com.example.javasessionhomeworkjpa.repositories.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdopterService implements IAdopterService {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Adopter> getAll() {
        return adopterRepository.findAll();
    }

    @Override
    public Adopter findAdopterById(Long adopterId) {
        return adopterRepository.findById(adopterId)
                .orElseThrow(() -> new EntityNotFoundException("Adopter not found with id: " + adopterId));
    }

    @Override
    public List<Adopter> findAdopterByName(String name) {
        return adopterRepository.findAdopterByName(name);
    }


    @Override
    public List<Adopter> findAdopterWithoutPets() {
        return adopterRepository.findAdopterWithoutPets();
    }

    @Override
    public List<Adopter> findAdopterWithPets() {
        return this.adopterRepository.findAdopterWithPets();
    }

    @Override
    public Adopter addAdopterWithPets(Adopter adopter) {
        adopter.getPets().forEach( pet -> pet.setAdopter(adopter));
        return adopterRepository.save(adopter);
    }

    @Override
    public Adopter updateAdopter(Long adopterId, Adopter updatedAdopter) {
        Adopter adopter = adopterRepository.findById(adopterId)
                .orElseThrow(() -> new EntityNotFoundException("Adopter not found with id: " + adopterId));

        adopter.setName(updatedAdopter.getName());
        adopter.setPhone_number(updatedAdopter.getPhone_number());

        return adopterRepository.save(adopter);
    }


    @Override
    public void deleteAdopter(Long adopterId) {
        Adopter adopter = adopterRepository.findById(adopterId)
                .orElseThrow(() -> new EntityNotFoundException("Adopter not found with id: " + adopterId));

        adopterRepository.delete(adopter);
    }
}

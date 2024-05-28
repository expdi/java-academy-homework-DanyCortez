package com.example.javasessionhomeworkjpa.interfaces;

import com.example.javasessionhomeworkjpa.clases.Adopter;

import java.util.List;

public interface IAdopterService {
    public List<Adopter> getAll();
    public Adopter findAdopterById(Long adopterId);
    public List<Adopter> findAdopterByName(String name);
    public List<Adopter> findAdopterWithoutPets();
    public List<Adopter> findAdopterWithPets();
    public Adopter addAdopterWithPets(Adopter adopter);
    public Adopter updateAdopter(Long adopterId, Adopter updatedAdopter);
    public void deleteAdopter(Long adopterId);
}

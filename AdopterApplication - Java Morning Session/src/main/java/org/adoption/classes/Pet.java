package org.adoption.classes;

import org.adoption.enums.Breed;
import org.adoption.enums.PetType;

import java.time.LocalDate;

public class Pet {
    private LocalDate adoptionDate;
    private PetType petType;
    private String name;
    private Breed breedType;

    public Pet(String name){
        this.name = name;
        this.breedType = Breed.UNKNOW;
        this.petType = PetType.UNKNOW;
        this.adoptionDate = LocalDate.now();
    }

    public Pet(LocalDate adoptionDate, PetType petType, String name, Breed breedType) {
        this.adoptionDate = adoptionDate;
        this.petType = petType;
        this.name = name;
        this.breedType = breedType;
    }

    public String toString(){
        return "Name: " + this.name +
                "\nPet type: " + this.petType +
                "\nAdoption date: " + this.adoptionDate +
                "\nBreed: " + this.breedType;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreedType() {
        return breedType;
    }

    public void setBreedType(Breed breedType) {
        this.breedType = breedType;
    }
}

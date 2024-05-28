package org.adoption.classes;

import org.adoption.enums.Breed;
import org.adoption.enums.PetType;

import java.time.LocalDate;

public class Pet {
    private LocalDate adoptionDate;
    private PetType petType;
    private String name;
    private Breed breedType;

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public String getName() {
        return name;
    }

    public Breed getBreedType() {
        return breedType;
    }
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
    public static PetBuilder builder(PetType type) {
        return new PetBuilder().setPetType(type.toString());
    }

    public static class PetBuilder {
        private LocalDate adoptionDate;
        private PetType petType;
        private String name;
        private Breed breedType;

        public PetBuilder setBreedType(String breedType) {
            this.breedType = Breed.valueOf(breedType.toUpperCase());
            return this;
        }

        public PetBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder setPetType(String petType) {
            this.petType = PetType.valueOf(petType.toUpperCase());
            return this;
        }

        public PetBuilder setAdoptionDate(LocalDate adoptionDate) {
            this.adoptionDate = adoptionDate;
            return this;
        }

        public Pet build() {
            return new Pet(adoptionDate, petType, name, breedType);
        }
    }
}

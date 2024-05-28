package org.adoption.classes;

import java.util.List;

public class Adopter {
    public Adopter(int id, String name, long phoneNumber, List<Pet> pet) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pet = pet;
    }

    public Adopter(AdopterBuilder adopterBuilder) {
        this.id = adopterBuilder.id;
        this.name = adopterBuilder.name;
        this.phoneNumber = adopterBuilder.phoneNumber;
        this.pet = adopterBuilder.pet;
    }

    private int id;
    private String name;
    private long phoneNumber;
    private Pet pet;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public Pet getPet() {
        return pet;
    }

    public static class AdopterBuilder {
        private int id;
        private String name;
        private long phoneNumber;
        private Pet pet;

        public Adopter Build() {
            return new Adopter(this);
        }
        public AdopterBuilder setId(int id) {
            this.id = id;
            return this;
        }
        public AdopterBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public AdopterBuilder setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public AdopterBuilder setPet(Pet pet) {
            this.pet = pet;
            return this;
        }
    }

}

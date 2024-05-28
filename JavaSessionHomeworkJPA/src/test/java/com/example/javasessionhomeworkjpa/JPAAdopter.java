package com.example.javasessionhomeworkjpa;

import com.example.javasessionhomeworkjpa.clases.Adopter;
import com.example.javasessionhomeworkjpa.clases.Pet;
import com.example.javasessionhomeworkjpa.enums.Breed;
import com.example.javasessionhomeworkjpa.enums.PetType;
import com.example.javasessionhomeworkjpa.repositories.AdopterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JPAAdopter {

    @Autowired
    private AdopterRepository adopterRepository;

    @Test
    public void testGetAll() {

        Pet pet = new Pet();
        pet.setName("Blacky");
        pet.setPet_type(PetType.NONE);
        pet.setBreed_type(Breed.NONE);
        pet.setAdoption_date(LocalDate.now());

        Pet pet1 = new Pet();
        pet.setName("Gorda");
        pet.setPet_type(PetType.CAT);
        pet.setBreed_type(Breed.ATIGRADO);
        pet.setAdoption_date(LocalDate.now().plusDays(-4));

        Adopter adopter = new Adopter();
        adopter.setName("Juan");
        adopter.setPhone_number(8474411114L);
        adopter.setPets(Arrays.asList(pet, pet1));

        adopterRepository.save(adopter);

        List<Adopter> adopterFound = adopterRepository.findAll();

        assertEquals(1, adopterFound.size());
        assertEquals("Juan", adopterFound.get(0).getName());
        assertEquals(8474411114L, adopterFound.get(0).getPhone_number());
    }

    @Test
    public void testCreate() {

        Pet pet = new Pet();
        pet.setName("Blacky");
        pet.setPet_type(PetType.NONE);
        pet.setBreed_type(Breed.NONE);
        pet.setAdoption_date(LocalDate.now());

        Pet pet1 = new Pet();
        pet.setName("Gorda");
        pet.setPet_type(PetType.CAT);
        pet.setBreed_type(Breed.ATIGRADO);
        pet.setAdoption_date(LocalDate.now().plusDays(-4));

        Adopter adopter = new Adopter();
        adopter.setName("Juan");
        adopter.setPhone_number(8474411114L);
        adopter.setPets(Arrays.asList(pet, pet1));

        adopterRepository.save(adopter);

        Optional<Adopter> adopterFound = adopterRepository.findById((long) adopter.getId());

        assertEquals("Juan", adopterFound.get().getName());
        assertEquals(8474411114L, adopterFound.get().getPhone_number());
    }
    @Test
    public void testUpdate() {

        Pet pet = new Pet();
        pet.setName("Blacky");
        pet.setPet_type(PetType.NONE);
        pet.setBreed_type(Breed.NONE);
        pet.setAdoption_date(LocalDate.now());

        Pet pet1 = new Pet();
        pet.setName("Gorda");
        pet.setPet_type(PetType.CAT);
        pet.setBreed_type(Breed.ATIGRADO);
        pet.setAdoption_date(LocalDate.now().plusDays(-4));

        Adopter adopter = new Adopter();
        adopter.setName("Juan");
        adopter.setPhone_number(8474411114L);
        adopter.setPets(Arrays.asList(pet, pet1));

        adopterRepository.save(adopter);

        adopter.setName("Alberto");
        adopter.setPhone_number(8474411114L);

        Optional<Adopter> adopterFound = adopterRepository.findById((long) adopter.getId());

        assertEquals("Alberto", adopterFound.get().getName());
    }

    @Test
    public void testDelete() {

        Pet pet = new Pet();
        pet.setName("Blacky");
        pet.setPet_type(PetType.NONE);
        pet.setBreed_type(Breed.NONE);
        pet.setAdoption_date(LocalDate.now());

        Pet pet1 = new Pet();
        pet.setName("Gorda");
        pet.setPet_type(PetType.CAT);
        pet.setBreed_type(Breed.ATIGRADO);
        pet.setAdoption_date(LocalDate.now().plusDays(-4));

        Adopter adopter = new Adopter();
        adopter.setName("Juan");
        adopter.setPhone_number(8474411114L);
        adopter.setPets(Arrays.asList(pet, pet1));

        adopterRepository.save(adopter);

        adopterRepository.delete(adopter);

        Optional<Adopter> adopterFound = adopterRepository.findById((long) adopter.getId());

        assertFalse(adopterFound.isPresent());
    }

}

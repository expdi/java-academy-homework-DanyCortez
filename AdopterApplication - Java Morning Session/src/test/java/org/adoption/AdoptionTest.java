package org.adoption;

import org.adoption.classes.Adopter;
import org.adoption.classes.Pet;
import org.adoption.enums.Breed;
import org.adoption.enums.PetType;
import org.adoption.services.AdoptionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles({"dev"})
public class AdoptionTest {

   @Autowired
   private AdoptionService adoptionService;

   @Test
   public void getAll() {

      adoptionService.add(new Adopter.AdopterBuilder().setId(1).setName("David Hernandez").setPhoneNumber(8674471174L).setPet(new Pet(LocalDate.now().plusDays(-47), PetType.Turtle, "Sammy", Breed.MANCHAS)).Build());

      List<Adopter> adopters = adoptionService.getAll();
      assertEquals(1, adopters.size());

      adopters.forEach(System.out::println);
   }

   @Test
   public void getAdopterWithExistingId() {

      adoptionService.add(new Adopter.AdopterBuilder().setId(4).setName("Elene Gonzalez").setPhoneNumber(8674471189L).setPet(new Pet(LocalDate.now().plusDays(-47), PetType.Turtle, "Sammy", Breed.MANCHAS)).Build());

      Adopter adopter = adoptionService.getById(4);

      assertNotNull(adopter);

     System.out.println(adopter);
   }

   @Test
   public void validateIfInsert() {

      adoptionService.add(new Adopter.AdopterBuilder().setId(4).setName("Elene Gonzalez").setPhoneNumber(8674471189L).setPet(new Pet(LocalDate.now().plusDays(-47), PetType.Turtle, "Sammy", Breed.MANCHAS)).Build());

      Adopter adopter = adoptionService.getById(4);

      assertNull(adopter);

      System.out.println(adopter);
   }

   @Test
   public void validateIfUpdate() {

      adoptionService.add(new Adopter.AdopterBuilder().setId(1).setName("Elene Gonzalez").setPhoneNumber(8674471189L).setPet(new Pet(LocalDate.now().plusDays(-47), PetType.Turtle, "Sammy", Breed.MANCHAS)).Build());

      Adopter adopter = adoptionService.getById(1);

      assertNull(adopter);

      System.out.println(adopter);
   }
}

package org.adoption;

import org.adoption.classes.Adopter;
import org.adoption.classes.Pet;
import org.adoption.enums.Breed;
import org.adoption.enums.PetType;
import org.adoption.services.AdoptionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class AdoptionApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();

        appContext.getEnvironment().setActiveProfiles("dev");
        appContext.register(AppConfig.class);
        appContext.refresh();

        AdoptionService adopterService = appContext.getBean("AdoptionService", AdoptionService.class);

        adopterService.add(new Adopter.AdopterBuilder()
                .setId(1)
                .setName("Jesus Cortez")
                .setPhoneNumber(8674471111L)
                .setPet(new Pet(LocalDate.now(), PetType.Cat, "Pia", Breed.ATIGRADO))
                .Build());

        adopterService.add(new Adopter.AdopterBuilder()
                .setId(2)
                .setName("Gabriel Alva")
                .setPhoneNumber(8674471174L)
                .setPet(new Pet(LocalDate.now().plusDays(1), PetType.Dog, "Blacky", Breed.MIXED))
                .Build());

        adopterService.add(new Adopter.AdopterBuilder()
                .setId(3)
                .setName("Marcus Dario")
                .setPhoneNumber(8674471198L)
                .setPet(new Pet(LocalDate.now().plusDays(-4), PetType.Dog, "Lady", Breed.MIXED))
                .Build());

        System.out.println();
        System.out.println("================FIND BY NAME METHOD=====================");
        System.out.println(adopterService.findByNameLike("Jesus"));
        System.out.println();

        System.out.println("================GET BY ID METHOD=====================");
        System.out.println(adopterService.getById(3));
        System.out.println();

        System.out.println("================GET SORTED BY ADOPTION DATE PET METHOD=====================");
        adopterService.getSortedByAdoptionDatePet().forEach(System.out::println);
        System.out.println();

        System.out.println("================GET ALL METHOD=====================");
        adopterService.getAll().forEach(System.out::println);
        System.out.println();
    }
}

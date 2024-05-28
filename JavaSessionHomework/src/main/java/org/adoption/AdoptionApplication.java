package org.adoption;

import org.adoption.classes.Adopter;
import org.adoption.classes.Pet;
import org.adoption.enums.Breed;
import org.adoption.enums.PetType;
import org.adoption.services.AdoptionService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@SpringBootApplication
public class AdoptionApplication  {

    public static void main(String[] args) {

        SpringApplication.run(AdoptionApplication.class, args);

//        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
//
//        appContext.getEnvironment().setActiveProfiles("dev");
//        appContext.register(AppConfig.class);
//        appContext.refresh();
//
//        AdoptionService adopterService = appContext.getBean("AdoptionService", AdoptionService.class);
//
//        adopterService.add(new Adopter.AdopterBuilder()
//                .setId(1)
//                .setName("Jesus Cortez")
//                .setPhoneNumber(8674471111L)
//                .setPet(new Pet(LocalDate.now(), PetType.Cat, "Pia", Breed.ATIGRADO))
//                .Build());
//
//        adopterService.add(new Adopter.AdopterBuilder()
//                .setId(2)
//                .setName("Gabriel Alva")
//                .setPhoneNumber(8674471174L)
//                .setPet(new Pet(LocalDate.now().plusDays(1), PetType.Dog, "Blacky", Breed.MIXED))
//                .Build());
//
//        adopterService.add(new Adopter.AdopterBuilder()
//                .setId(3)
//                .setName("Marcus Dario")
//                .setPhoneNumber(8674471198L)
//                .setPet(new Pet(LocalDate.now().plusDays(-4), PetType.Dog, "Lady", Breed.MIXED))
//                .Build());
//
//        System.out.println();
//        System.out.println("================FIND BY NAME METHOD=====================");
//        System.out.println(adopterService.findByNameLike("Jesus"));
//        System.out.println();
//
//        System.out.println("================GET BY ID METHOD=====================");
//        System.out.println(adopterService.getById(3));
//        System.out.println();
//
//        System.out.println("================GET SORTED BY ADOPTION DATE PET METHOD=====================");
//        adopterService.getSortedByAdoptionDatePet().forEach(System.out::println);
//        System.out.println();
//
//        System.out.println("================GET ALL METHOD=====================");
//        adopterService.getAll().forEach(System.out::println);
//        System.out.println();
    }
}

@Component
class MyRunner implements CommandLineRunner{

    final AdoptionService adoptionService;

    public MyRunner(AdoptionService adoptionService){
        this.adoptionService = adoptionService;
    }

    @Override
    public void run(String... args) throws Exception {

        //Connection PostgresSQL
        String url = "jdbc:postgresql://localhost:5433/adoptionapp";
        String usuario = "larku";
        String password = "larku";

        try {
            Class.forName("org.postgresql.Driver");

            Connection conexion = DriverManager.getConnection(url, usuario, password);

            if(conexion != null) {
                System.out.println("Conexion exitosa");
            } else {
                System.out.println("No se pudo establecer conexion");
            }

            conexion.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
          String x =  e.toString();
        }

        List<Adopter> adopters = adoptionService.getAll();
    }
}

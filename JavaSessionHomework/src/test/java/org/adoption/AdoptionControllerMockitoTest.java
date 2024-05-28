package org.adoption;

import org.adoption.classes.Adopter;
import org.adoption.classes.Pet;
import org.adoption.controllers.AdoptionController;
import org.adoption.enums.Breed;
import org.adoption.enums.PetType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.adoption.services.AdoptionService;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AdoptionControllerMockitoTest {

    @Mock
    private AdoptionService adoptionService;

    @InjectMocks
    private AdoptionController adoptionController;

//    private List<Adopter> adopters = List.of(
//            new Adopter(1, "Jesus Cortez", 8747777763L, Pet.builder(PetType.DOG).setName("Blacky").setBreedType(Breed.MIXED.toString()).setAdoptionDate(LocalDate.now()).build()),
//            new Adopter(2, "Graham Valdez", 8747777887L, Pet.builder(PetType.CAT).setName("Gorda").setBreedType(Breed.MIXED.toString()).setAdoptionDate(LocalDate.now().plusDays(1)).build()),
//            new Adopter(3, "Jose Antonio", 8747777823L, Pet.builder(PetType.cat).setName("Max").setBreedType(Breed.MIXED.toString()).setAdoptionDate(LocalDate.now().plusDays(3)).build())
//    );

    @Test
    public void testGetAll() throws Exception {

//        Mockito.when(adoptionService.getAll()).thenReturn(adopters);
//
//        ResponseEntity<?> response = adoptionController.getAll();
//
//        System.out.println(response.toString());
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//
//        Mockito.verify(adoptionService).getAll();
    }

    @Test
    public void testGetId() throws Exception {

//        Adopter adopter =  new Adopter(1, "Jesus Cortez", 8747777763L, Pet.builder(PetType.Dog).setName("Blacky").setBreedType(Breed.MIXED.toString()).setAdoptionDate(LocalDate.now()).build());
//
//        Mockito.when(adoptionService.getById(1)).thenReturn(adopter);
//
//        ResponseEntity<?> response = adoptionController.getById(1);
//
//        System.out.println(response.toString());
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//
//        Mockito.verify(adoptionService).getById(1);
    }
}

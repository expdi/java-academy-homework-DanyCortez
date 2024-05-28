package org.adoption.interfaces;

import org.adoption.classes.Adopter;

import java.util.List;

public interface IAdoptionService {
    List<Adopter> getAll();
    Adopter add(Adopter adopter);
    boolean update(Adopter adopter);
    boolean delete(int id);
    Adopter getById(int id);
    List<Adopter> findByNameLike(String name);
    List<Adopter> getSortedByAdoptionDatePet();
}

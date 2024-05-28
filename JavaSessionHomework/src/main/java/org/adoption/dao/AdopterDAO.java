package org.adoption.dao;

import org.adoption.classes.Adopter;

import java.util.List;

public interface AdopterDAO {
    List<Adopter> getAll();
    Adopter insert(Adopter adopter);
    boolean update(Adopter adopter);
    boolean delete(int id);
    Adopter findById(int id);
    List<Adopter> findByNameLike(String name);
}

package org.adoption.dao.InMemory;

import org.adoption.classes.Adopter;
import org.adoption.dao.AdopterDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Profile("dev")
public class InMemoryAdopter implements AdopterDAO {
    private Map<Integer, Adopter> adopters;

    private int idCounter = 1;

    public InMemoryAdopter() {
        adopters = new HashMap<>();
        System.out.print("InMemoryAdopterClass");
        System.out.println();
    }

    @Override
    public List<Adopter> getAll() {
        return new ArrayList<>(this.adopters.values());
    };

    @Override
    public Adopter insert(Adopter adopter) {
        this.adopters.put(adopter.getId(), adopter);
        return adopter;
    }

    @Override
    public boolean delete(int adopterId) {

        return this.adopters.remove(adopterId) != null;
    };

    @Override
    public boolean update(Adopter adopter) {

        return this.adopters.replace(adopter.getId(), adopter) != null;
    };

    @Override
    public Adopter findById(int id) {

        return this.adopters.get(id);
    };

    @Override
    public List<Adopter> findByNameLike(String name) {
        return this.adopters.values()
                .stream()
                .filter(adopter -> adopter.getName().contains(name))
                .collect(Collectors.toList());
    }
}

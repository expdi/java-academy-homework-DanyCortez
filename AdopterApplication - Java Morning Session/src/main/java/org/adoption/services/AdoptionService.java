package org.adoption.services;

import org.adoption.classes.Adopter;
import org.adoption.classes.Pet;
import org.adoption.dao.AdopterDAO;
import org.adoption.dao.DAOFactory;
import org.adoption.interfaces.IAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("AdoptionService")
public class AdoptionService implements IAdoptionService {

    @Autowired
    private AdopterDAO adopter;

    public AdoptionService() { this.adopter = DAOFactory.getAdopterDAO(); };
    public List<Adopter> getAll() { return this.adopter.getAll(); };
    public Adopter add(Adopter adopter) {return this.adopter.insert(adopter); };
    public boolean delete(int id) { return this.adopter.delete(id); };
    public boolean update(Adopter adopter) { return this.adopter.update(adopter); };
    public Adopter getById(int id) { return this.adopter.findById(id); };
    public List<Adopter> findByNameLike(String name) { return this.adopter.findByNameLike(name); };
    public List<Adopter> getSortedByAdoptionDatePet() {
        return this.adopter
                .getAll()
                .stream()
                .sorted(Comparator.comparing(adopt -> adopt.getPet().getAdoptionDate()))
                .collect(Collectors.toList());
    }

    public List<Adopter> customSearch(String attributeName, Object value){
        return this.adopter.getAll().stream()
                .map(adopter -> {
                    try {
                        return convertUsingReflection(adopter);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(adopterMapped -> adopterMapped.get(attributeName) == value)
                .map(filteredAdopterMapped -> new Adopter.AdopterBuilder()
                        .setId((Integer) filteredAdopterMapped.get("id"))
                        .setName((String) filteredAdopterMapped.get("name"))
                        .setPhoneNumber((long) filteredAdopterMapped.get("phoneNumber"))
                        .setPet((Pet) filteredAdopterMapped.get("pet"))
                        .Build())
                .collect(Collectors.toList());
    }

    private Map<String, Object> convertUsingReflection(Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field: fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object));
        }

        return map;
    }
}

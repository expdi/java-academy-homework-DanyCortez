package org.adoption.dao.JDBC;

import org.adoption.RowMappers.AdopterRowMapper;
import org.adoption.classes.Adopter;
import org.adoption.classes.Pet;
import org.adoption.dao.AdopterDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("dev")
public class JDBCAdopter implements AdopterDAO {

    @Override
    public List<Adopter> getAll() {

        try {
            String sql = "SELECT " +
                    "a.id as idAdopter," +
                    "a.name as adopterName, " +
                    "a.phoneNumber, " +
                    "p.id as idPet," +
                    "p.name as petName, " +
                    "p.pettype, " +
                    "p.breedtype, " +
                    "p.adoptiondate " +
                    "FROM adopter a JOIN pet p ON a.id = p.idadopterrelated";

            List<Adopter> adopters = getJdbcTempalte().query(sql, new AdopterRowMapper());

            Map<Adopter, List<Pet>> adoptersWithPets = new HashMap<>();

            for(Adopter adopter: adopters) {
                if(!adoptersWithPets.containsKey(adopter)) {
                    adoptersWithPets.put(adopter, adopter.getPet());
                }
            }

            return new ArrayList<Adopter>();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Adopter insert(Adopter adopter) {


        return null;
    }

    @Override
    public boolean update(Adopter adopter) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Adopter findById(int id) {
        return null;
    }

    @Override
    public List<Adopter> findByNameLike(String name) {
        return null;
    }

    private JdbcTemplate getJdbcTempalte() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/adoptionapp");
        dataSource.setUsername("larku");
        dataSource.setPassword("larku");

        return new JdbcTemplate(dataSource);
    }
}

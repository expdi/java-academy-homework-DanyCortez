package org.adoption.RowMappers;

import org.adoption.classes.Adopter;
import org.adoption.classes.Pet;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdopterRowMapper implements RowMapper<Adopter> {

//    @Override
//    public Adopter mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//        Adopter.AdopterBuilder adopterBuilder = new Adopter.AdopterBuilder()
//                .setId(rs.getInt("idAdopter"))
//                .setName(rs.getString("adopterName"))
//                .setPhoneNumber(rs.getLong("phoneNumber"));
//
//        Pet.PetBuilder petBuilder = new Pet.PetBuilder()
//                .setName(rs.getString("petName"))
//                .setPetType(rs.getString("pettype"))
//                .setBreedType(rs.getString("breedtype"))
//                .setAdoptionDate(rs.getDate("adoptiondate").toLocalDate());
//
//        return adopterBuilder.setPet(List.of(petBuilder.build())).Build();
//    }

    @Override
    public Map<Integer, Adopter> mapRow(ResultSet rs, int rowNum) throws SQLException {
        Map<Integer, Adopter> personaMap = new HashMap<>();

        do {
            int idAdopter = rs.getInt("idAdopter");

            Adopter.AdopterBuilder adopterBuilder = new Adopter.AdopterBuilder()
                .setId(rs.getInt("idAdopter"))
                .setName(rs.getString("adopterName"))
                .setPhoneNumber(rs.getLong("phoneNumber"));

            int idPet = rs.getInt("idPet");

//            if(idPet > 0) {
//                Pet.PetBuilder petBuilder = new Pet.PetBuilder()
//                      .setName(rs.getString("petName"))
//                     .setPetType(rs.getString("pettype"))
//                     .setBreedType(rs.getString("breedtype"))
//                     .setAdoptionDate(rs.getDate("adoptiondate").toLocalDate());
//
//                adopterBuilder.;
//            }
        }

    }
}

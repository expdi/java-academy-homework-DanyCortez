
CREATE TABLE Adopter
(
    adopter_id          serial primary key not null,
    name        VARCHAR(255) NOT NULL,
    phone_number BIGINT
);

CREATE TABLE Pet
(
    pet_id          serial primary key not null,
    name        VARCHAR(255) NOT NULL,
    breed_type   VARCHAR(255),
    pet_type     VARCHAR(255),
    adoption_date DATE,
    adopter_id serial

);

-- Add Constraints
ALTER TABLE Pet
    ADD CONSTRAINT fk_adopter_relation_pet FOREIGN KEY (adopter_id)
        REFERENCES Adopter (adopter_id);
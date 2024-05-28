
CREATE TABLE Adopter
(
    id          serial primary key not null,
    name        VARCHAR(255) NOT NULL,
    phoneNumber BIGINT
);

CREATE TABLE Pet
(
    id          serial primary key not null,
    name        VARCHAR(255) NOT NULL,
    breedType   VARCHAR(255),
    petType     VARCHAR(255),
    adoptionDate DATE,
    idAdopterRelated serial

);

-- Add Constraints
ALTER TABLE Pet
    ADD CONSTRAINT fk_adopter_relation_pet FOREIGN KEY (idAdopterRelated)
        REFERENCES Adopter (id);
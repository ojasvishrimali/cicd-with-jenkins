package com.petapplication.repository;

import com.petapplication.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    Optional<Pet> findByPetType(String petType);


//   Boolean isPetExistById(Integer petId);
}

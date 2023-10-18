package com.petapplication.service;

import com.petapplication.entity.Pet;
import com.petapplication.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
//get all pets
    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }
    //get pets by id
    public Optional<Pet> getPetById(Long petId){
        return petRepository.findById(petId);
    }

     // Add a new pet
    public Pet addPet(Pet pet){
        return petRepository.save(pet);
    }

// get pet by pet type
    public Optional<Pet> getPetByType(String petType) {
        return petRepository.findByPetType(petType);
    }


    // Update an existing pet
    public Optional<Pet> updatePet(Long petId,Pet updatedPet){
        Optional<Pet> existingPet=petRepository.findById(petId);
        if(existingPet.isPresent()){
            updatedPet.setPetId(petId);
            return Optional.of(petRepository.save(updatedPet));
        }else{
            return Optional.empty();
        }
    }

    // Delete a pet by ID
    public boolean deletePet(Long petId){
        if(petRepository.existsById(petId)){
            petRepository.deleteById(petId);
            return true;
        }else{
            return false;
        }
    }
}

package com.petapplication.controller;

import com.petapplication.entity.Pet;
import com.petapplication.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;


    // Create
    @PostMapping("/add-pet")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet){
        Pet addedPet=petService.addPet(pet);
        return ResponseEntity.ok(addedPet);
    }

    // Read all pets
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> petList = petService.getAllPets();
        return ResponseEntity.ok(petList);
    }

    // Read pet by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.getPetById(id);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/byType/{petType}")
    public ResponseEntity<Pet> getPetByType(@PathVariable String petType) {
        Optional<Pet> pet = petService.getPetByType(petType);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Update pet by id
    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet updatedPet) {
        Optional<Pet> pet = petService.updatePet(id, updatedPet);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Delete pet by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable Long id) {
        if (petService.deletePet(id)) {
            return ResponseEntity.ok("Pet deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

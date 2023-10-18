package com.petapplication.service;

import com.petapplication.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @Mock
    private PetRepository petRepository;
    @Autowired
    private PetService petService;

    @BeforeEach
    void setUp() {
        this.petService=new PetService(this.petRepository);

    }


    @Test
    void getAllPets() {
        petService.getAllPets();
         verify(petRepository).findAll();



    }
}
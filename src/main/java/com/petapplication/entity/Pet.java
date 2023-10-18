package com.petapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pet {


    // it will give the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//the primary key will be generated automatically by the database
    private Long petId;
    private String petName;
    private String petType;

    //default constructor
    public Pet() {
    }



    public Pet(long petId, String petName, String petType) {
        this.petId = petId;
        this.petName = petName;
        this.petType = petType;
    }
    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", petType='" + petType + '\'' +
                '}';
    }
}

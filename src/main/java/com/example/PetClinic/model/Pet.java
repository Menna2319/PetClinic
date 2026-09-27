package com.example.PetClinic.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pet")
public class Pet {


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;




    private String petName;
    private String petType;
    private String petBreed;
    private String sex;
    private double petWeight;
    private String petHistory;
    private LocalDate dateOfBirth;



    public Pet() {
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(double petWeight) {
        this.petWeight = petWeight;
    }

    public String getPetHistory() {
        return petHistory;
    }

    public void setPetHistory(String petHistory) {
        this.petHistory = petHistory;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}

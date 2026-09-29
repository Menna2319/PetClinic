package com.example.PetClinic.model;

import jakarta.persistence.*;
import java.util.List ;

@Entity
@Table (name = "owners")
public class Owner {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    public Owner() {
    }
    public Long getId() {
       return id;
    }
    public void  setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}

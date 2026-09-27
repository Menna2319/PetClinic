package com.example.PetClinic.repository;
import com.example.PetClinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}

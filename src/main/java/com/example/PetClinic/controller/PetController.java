package com.example.PetClinic.controller;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.model.Pet;
import com.example.PetClinic.repository.OwnerRepository;
import com.example.PetClinic.repository.PetRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetController {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetController(PetRepository petRepository,
                         OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/pets")
    public String petsPage(HttpSession session, Model model) {

        Long ownerId = (Long) session.getAttribute("ownerId");

        if (ownerId == null) {
            return "redirect:/login";
        }

        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        model.addAttribute("owner", owner);
        model.addAttribute("pets", petRepository.findByOwnerId(ownerId));
        model.addAttribute("pet", new Pet());

        return "pets";
    }

    @PostMapping("/pets/add")
    public String addPet(@ModelAttribute Pet pet,
                         HttpSession session) {

        Long ownerId = (Long) session.getAttribute("ownerId");

        if (ownerId == null) {
            return "redirect:/login";
        }

        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        pet.setOwner(owner);
        petRepository.save(pet);

        return "redirect:/pets";
    }
}
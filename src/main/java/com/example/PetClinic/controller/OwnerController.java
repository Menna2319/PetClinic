package com.example.PetClinic.controller;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.repository.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class OwnerController {

        private final OwnerRepository ownerRepository;

        public OwnerController(OwnerRepository ownerRepository) {
            this.ownerRepository = ownerRepository;
        }

        @GetMapping("/owners")
        public String ownersPage(Model model) {
            model.addAttribute("owner", new Owner());
            model.addAttribute("owners", ownerRepository.findAll());

            return "owners";
        }

        @PostMapping("/owners")
        public String addOwner(@ModelAttribute Owner owner) {
            ownerRepository.save(owner);

            return "redirect:/owners";
        }
    }


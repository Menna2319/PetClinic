package com.example.PetClinic.controller;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.repository.OwnerRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final OwnerRepository ownerRepository;

    public LoginController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, HttpSession session, Model model) {

        Owner owner = ownerRepository.findByEmail(email).orElse(null);

        if (owner == null) {
            model.addAttribute("error", "Email not found");
            return "login";
        }

        session.setAttribute("ownerId", owner.getId());

        return "redirect:/Appointments";
    }
}
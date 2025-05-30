package com.springframework.webapp.controllers;

import com.springframework.webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @RequestMapping("/authors")
    public String showAuthors(Model model) {
        model.addAttribute("authors", authorRepo.findAll());
        return "authors/list";
    }
}

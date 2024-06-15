package com.cloudcom2024.store.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcom2024.store.dtos.PersonalityTypeResponse;
import com.cloudcom2024.store.services.PersonalityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Tag(name = "Персоналии", description = "Работа с персоналиями")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/personalities")
public class PersonalityController {
    final private PersonalityService personalityService;

    PersonalityController(
        PersonalityService personalityService
    ) {
        this.personalityService = personalityService;
    }

    @GetMapping
    @Operation(description = "Получение всех типов личности")
    public List<PersonalityTypeResponse> getAllPersonalities() {
        return personalityService.findAllPersonalities();
    }
}

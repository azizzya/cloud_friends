package com.cloudcom2024.store.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cloudcom2024.store.dtos.RegistrationFormRequest;
import com.cloudcom2024.store.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Безопасность")
@CrossOrigin(origins = "localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/register")
public class RegistrationController {
    private UserService userDetailsService;
    
    public RegistrationController(UserService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    @Operation(description = "Регистрация нового пользователя")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Пользователь уже был зарегестрирован или формат username, firstname, lastname, password заданы не верно")
        }
    )
    public void processRegistration(@RequestBody RegistrationFormRequest registrationForm) {
        userDetailsService.saveUser(registrationForm.convertToUser());
    }
}

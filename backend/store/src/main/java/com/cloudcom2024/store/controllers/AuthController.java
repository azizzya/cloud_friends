package com.cloudcom2024.store.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcom2024.store.dtos.AuthRequest;
import com.cloudcom2024.store.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.security.auth.message.AuthException;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Безопасность", description = "Аутентификация")
@CrossOrigin(origins = "localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/auth")
public class AuthController {
    final private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(description = "Аутентифицировать пользователя")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Пароль или имя пользователя указаны не в том формате"),
            @ApiResponse(responseCode = "401", description = "Пользователь с данным пароллем и именем не найдены")
        }
    )
    public void authUser(@RequestBody @Valid AuthRequest authRequest) throws AuthException {
        userService.authUser(authRequest);
    }
    
}

package com.cloudcom2024.store.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcom2024.store.dtos.PersonalityTypeResponse;
import com.cloudcom2024.store.dtos.UserResponse;
import com.cloudcom2024.store.services.UserService;
import com.cloudcom2024.store.utils.Base64Decoder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "Пользователи", description = "Взаимодествие с пользователями")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/users")
public class UserController {
    final private UserService userService;
    final private Base64Decoder base64Decoder;

    UserController(
        UserService userService,
        Base64Decoder base64Decoder
    ) {
        this.userService = userService;
        this.base64Decoder = base64Decoder;
    }

    @GetMapping("/leadersboard")
    @Operation(description = "Получение лидерборда")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK")
        }
    )
    public List<UserResponse> getLeaderBoard() {
        return userService.getAllUsersSortByCoinBalanceDESCWithLimit100();
    }

    @GetMapping
    @Operation(description = "Получение профиля авторизованного пользователя")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK")
        }
    )
    public UserResponse getUserProfile(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization
    ) {
        String username = base64Decoder.basicAuthDecoder(authorization)[0];
        return userService.getUserByUsername(username);
    }

    @GetMapping("/personality-type")
    @Operation(description = "Получение типа личности пользователя")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK")
        }
    )
    public PersonalityTypeResponse getAuthorizedUserPersonalityType(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization
    ) {
        String username = base64Decoder.basicAuthDecoder(authorization)[0];
        return userService.getPersonalityTypeByUsername(username);
    }
    

}

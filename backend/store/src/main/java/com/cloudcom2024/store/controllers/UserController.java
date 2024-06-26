package com.cloudcom2024.store.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcom2024.store.dtos.PersonalityTypeResponse;
import com.cloudcom2024.store.dtos.PersonalityTypeTestRequest;
import com.cloudcom2024.store.dtos.UserResponse;
import com.cloudcom2024.store.services.ImageService;
import com.cloudcom2024.store.services.UserService;
import com.cloudcom2024.store.utils.Base64Decoder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Пользователи", description = "Взаимодествие с пользователями")
@CrossOrigin(origins = {"http://localhost:5173", "http://5.35.86.32:3000"}, allowCredentials = "true")
@RestController
@RequestMapping("/users")
public class UserController {
    final private UserService userService;
    final private ImageService imageService;
    final private Base64Decoder base64Decoder;

    UserController(
        UserService userService,
        ImageService imageService,
        Base64Decoder base64Decoder
    ) {
        this.userService = userService;
        this.imageService = imageService;
        this.base64Decoder = base64Decoder;
    }

    @GetMapping("/leaderboard")
    @Operation(description = "Получение лидерборда")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK")
        }
    )
    public List<UserResponse> getLeaderBoard() {
        return userService.getAllUsersSortByCoinBalanceDESCWithLimit100();
    }

    @GetMapping("/profile")
    @Operation(description = "Получение профиля пользователя по полю Authorization")
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

    @PostMapping("/personality")
    @Operation(description = "Поставить тип личности пользователю по полю Authorization")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "null в body"),
            @ApiResponse(responseCode = "404", description = "тип личности не найден")
        }
    )
    public void setUserPersonality(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization,
        @RequestBody List<PersonalityTypeTestRequest> personalityTypeTestRequest
    ) {
        String username = base64Decoder.basicAuthDecoder(authorization)[0];
        userService.setUserPersonality(username, personalityTypeTestRequest);
    }
    

    @GetMapping("/personality")
    @Operation(description = "Получение типа личности пользователя по полю Authorization")
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

    @GetMapping("/images/{imageName}")
    @Operation(description = "Получение картинки профиля пользователя")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Картинка профиля пользователя не найдена")
        }
    )
    public ResponseEntity<byte[]> getUserImage(@PathVariable String imageName) throws IOException {
        byte[] image = imageService.downloadUserProfileImage(imageName);
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.IMAGE_JPEG)
            .body(image);
    }
}

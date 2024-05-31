package com.cloudcom2024.store.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcom2024.store.dtos.TamagotchiResponse;
import com.cloudcom2024.store.services.TamagotchiService;
import com.cloudcom2024.store.utils.Base64Decoder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Тамагочи")
@CrossOrigin(origins = "localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/tamagotchi")
public class TamagotchiController {
    final private TamagotchiService tamagotchieService;
    final private Base64Decoder base64Decoder;

    public TamagotchiController(
        TamagotchiService tamagotchieService,
        Base64Decoder base64Decoder
    ) {
        this.tamagotchieService = tamagotchieService;
        this.base64Decoder = base64Decoder;
    }

    @GetMapping
    @Operation(description = "Получение тамаготчи по авторизированному пользователю")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK")
        }
    )
    public TamagotchiResponse getTamagotchi(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization
    ) {
        String username = base64Decoder.basicAuthDecoder(authorization)[0];

        return tamagotchieService.getTamagotchiByUserName(username)
            .convertToTamagotchiResponse();
    }
}

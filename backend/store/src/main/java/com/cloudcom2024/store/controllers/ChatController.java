package com.cloudcom2024.store.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cloudcom2024.store.dtos.ChatMessageRequest;
import com.cloudcom2024.store.dtos.ChatResponse;
import com.cloudcom2024.store.dtos.MessageResponse;
import com.cloudcom2024.store.services.GigaChatService;
import com.cloudcom2024.store.utils.Base64Decoder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@Tag(name = "Giga chat", description = "Взаимодействие с giga chat'ом")
@CrossOrigin(origins = "localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/gigachat")
public class ChatController {
    final private GigaChatService gigaChatService;
    final private Base64Decoder base64Decoder;

    public ChatController(
        GigaChatService gigaChatService,
        Base64Decoder base64Decoder
    ) {
        this.gigaChatService = gigaChatService;
        this.base64Decoder = base64Decoder;
    }

    @PostMapping
    @Operation(description = "сделать запрос к модели gigachat")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "role или message указаны не в том формате"),
            @ApiResponse(responseCode = "500", description = "SSL сертификат не установлен или неверная переменная GIGACHAT_AUTHTOKEN")
        }
    )
    public ChatResponse sendRequestToGigaChat(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization,
        @RequestBody @Valid ChatMessageRequest chatMessageRequest
    ) {
        String username = base64Decoder.basicAuthDecoder(authorization)[0];
        chatMessageRequest.setUsername(username);

        String message = gigaChatService.getMessage(chatMessageRequest);
        return ChatResponse.builder()
            .message(message)
            .build();
    }

    @GetMapping("/responses")
    @Operation(description = "получить ответы от модели gigachat")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
        }
    )
    public List<MessageResponse> getAllResponsesFromGigaChat(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization
    ) {
        String username = base64Decoder.basicAuthDecoder(authorization)[0];

        return gigaChatService.getAllMessagesByUsername(username).stream()
            .map(x -> x.convertToMessageResponse())
            .collect(Collectors.toList());
    }
}
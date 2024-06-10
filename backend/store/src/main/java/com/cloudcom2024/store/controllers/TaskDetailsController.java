package com.cloudcom2024.store.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcom2024.store.dtos.TaskDetailsRequest;
import com.cloudcom2024.store.dtos.TaskDetailsResponse;
import com.cloudcom2024.store.services.TaskDetailsService;
import com.cloudcom2024.store.utils.Base64Decoder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Tag(name = "Непосредственные задания", description = "Действия, связаннные с непосредственными заданиями")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/tasks/details")
public class TaskDetailsController {
    final private TaskDetailsService taskDetailsService;    
    final private Base64Decoder base64Decoder;

    public TaskDetailsController(
        TaskDetailsService taskDetailsRepository,
        Base64Decoder base64Decoder
    ) {
        this.taskDetailsService = taskDetailsRepository;
        this.base64Decoder = base64Decoder;
    }

    @PatchMapping("/complete")
    @Operation(description = "завершение задания по username авторизированного пользователя и friend id")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "задания с таким friend id нет у данного пользователя")
        }
    )
    public void completeTask(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization,
        @RequestParam("friend_id") long friendID
    ) {
        String currentUsername = base64Decoder.basicAuthDecoder(authorization)[0];
        taskDetailsService.completeTaskByCurrentUserUsernameAndFriendID(currentUsername, friendID);
    }

    @GetMapping
    @Operation(description = "Получения списка заданий пользователя, то есть с детализацией задания и самим заданием")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK")
        }
    )
    public List<TaskDetailsResponse> getAllTaskDetailsByUser(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization
    ) {
        String username = base64Decoder.basicAuthDecoder(authorization)[0];
        return taskDetailsService.getAllTaskDetailsByUsername(username);
    }
    

    @PostMapping
    @Operation(description = "Выдача задания пользователю с детализацией")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Поля не прошли проверку валидации или у пользователя может быть только одно задание"),
            @ApiResponse(responseCode = "404", description = "Пользователь или его друг, или таска с таким id не найдены")
        }
    )
    public void createTaskDetails(@RequestBody @Valid TaskDetailsRequest taskDetailsRequest) {
        taskDetailsService.createTaskDetails(taskDetailsRequest);
    }
    
}
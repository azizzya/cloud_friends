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
            @ApiResponse(responseCode = "400", description = "Задание с friend_id или task id и friend username указаны не в том формате")
        }
    )
    public void completeTask(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization,
        @RequestParam("friend_id") long friendID
    ) {
        String currentUsername = base64Decoder.basicAuthDecoder(authorization)[0];
        taskDetailsService.completeTaskByCurrentUserUsernameAndFriendID(currentUsername, friendID);
        

        //String friendUsername = taskDetailRequest.getFriendUsername();
        //Long taskID = taskDetailRequest.getTaskID();
        //TaskDetailsRequest taskDetailsRequest = TaskDetailsRequest.builder()
            //.currentUserUsername(currentUsername)
            //.friendUsername(friendUsername)
            //.taskID(taskID)
            //.build();

        //taskDetailsService.setTaskIsDoneForCurrentUserAndFriend(taskDetailsRequest);
    }

    //@GetMapping
    //@Operation(description = "Получения списка непосредсвенных заданий пользователя, то есть с детализацией задания и самим заданием")
    //@ApiResponses(
        //value = {
            //@ApiResponse(responseCode = "200", description = "OK")
        //}
    //)
    //public List<TaskDetailsResponse> getAllTaskDetailsByUser(
        //@RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization
    //) {
        //String username = base64Decoder.basicAuthDecoder(authorization)[0];
        //return taskDetailsService.getAllTaskDetailsByUsername(username);
    //}
    

    @PostMapping
    public void createTaskDetails(@RequestBody TaskDetailsRequest taskDetailsRequest) {
        taskDetailsService.createTaskDetails(taskDetailsRequest);
    }
    
}
package com.cloudcom2024.store.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cloudcom2024.store.dtos.TaskRequest;
import com.cloudcom2024.store.dtos.TaskResponse;
import com.cloudcom2024.store.services.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Tag(name = "Прототипы заданий", description = "Для действий, связанных с прототипами заданиями")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    final private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @Operation(description = "Получение списка заданий по авторизованному пользователю")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK")
        }
    )
    public List<TaskResponse> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    @Operation(description = "Создание задания")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "json не прошел валидацию")
        }
    )
    public void createTaskByHands(@RequestBody TaskRequest taskRequest) {
        taskService.createTaskByHands(taskRequest);
    }

    @PostMapping("/ai")
    public void createTaskWithAI(@RequestParam("personality_id") long personalityTypeID) {
        taskService.createTaskByAI(personalityTypeID);
    }
    
    

    @DeleteMapping("/{taskID}")
    @Operation(description = "Удаление задания по id задания")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTaskById(taskId);
    }
}

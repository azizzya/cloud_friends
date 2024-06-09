package com.cloudcom2024.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloudcom2024.store.dtos.TaskRequest;
import com.cloudcom2024.store.dtos.TaskResponse;
import com.cloudcom2024.store.models.Task;
import com.cloudcom2024.store.repositories.TaskRepository;

@Service
public class TaskService {
    final private TaskRepository taskRepository;    

    public TaskService(TaskRepository taskDetailRepository) {
        this.taskRepository = taskDetailRepository;
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
            .map(task -> task.convertToTaskResponse())
            .toList();
    }
    
    public void createTaskByHands(TaskRequest taskRequest) {
        Task task = taskRequest.convertToTask();
        taskRepository.save(task);
    }

    public void deleteTaskById(Long TaskDetailId) {
        taskRepository.deleteById(TaskDetailId);
    }

    public void partiallyUpdateTask(Task task) {
        Long taskDetailId = task.getTaskID();
        if (taskRepository.findById(taskDetailId).isPresent()) {
            taskRepository.save(task);
        }
    }
}

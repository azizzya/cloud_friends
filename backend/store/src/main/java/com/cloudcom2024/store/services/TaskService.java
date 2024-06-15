package com.cloudcom2024.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cloudcom2024.store.daos.MessageDAO;
import com.cloudcom2024.store.daos.MessageWithParammetersDAO;
import com.cloudcom2024.store.dtos.GigaChatAccessTockenResponse;
import com.cloudcom2024.store.dtos.TaskRequest;
import com.cloudcom2024.store.dtos.TaskResponse;
import com.cloudcom2024.store.exceptions.PersonalityTypeNotFound;
import com.cloudcom2024.store.models.PersonalityType;
import com.cloudcom2024.store.models.Task;
import com.cloudcom2024.store.processors.ChatMessageProccessor;
import com.cloudcom2024.store.repositories.PersonalityTypeRepository;
import com.cloudcom2024.store.repositories.TaskRepository;

@Service
public class TaskService {
    final private TaskRepository taskRepository;    
    final private ChatMessageProccessor chatMessageProccessor;
    final private PersonalityTypeRepository personalityTypeRepository;

    final private String INIT_PROMPT = """
    Представь что ты психиатр с 25 летним стажем.
    Твоя задача генерировать задачи для пользователей приложения. Запомни, задача подтверждается с помощью QR кода. Придерживайся следующих правил: задачи должны быть несложными, задачи должны быть основаны на взаимодействии вживую между коллегами по работе, задачи должны учитывать тип личности человека, ответ должен быть сгенерирован без каких либо обоснований или пояснений.
    Заголовок задачи и текст задачи разделяются знаком ":" и пишутся в одной строчке, например, Прогулка: Сходи в парк вместе с коллегой по работе. Запомни этот пример именно на основе его шаблона ты должен генерировать задания. 
    """;

    public TaskService(
        TaskRepository taskDetailRepository,
        ChatMessageProccessor chatMessageProccessor, 
        PersonalityTypeRepository personalityTypeRepository
    ) {
        this.taskRepository = taskDetailRepository;
        this.chatMessageProccessor = chatMessageProccessor;
        this.personalityTypeRepository = personalityTypeRepository;
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
            .map(task -> task.convertToTaskResponse())
            .toList();
    }
    
    public void createTaskByHands(TaskRequest taskRequest) {
        Task task = taskRequest.convertToTask();
        task.setAI(false);
        taskRepository.save(task);
    }

    public void createTaskByAI(long personalityTypeID) {
        GigaChatAccessTockenResponse token = chatMessageProccessor.getCurrentToken();
        if (token == null || token.isTokenExpired()) {
            chatMessageProccessor.updateToken();
        }

        Optional<PersonalityType> personalityType = personalityTypeRepository.findById(personalityTypeID);
        if (!personalityType.isPresent()) {
            throw new PersonalityTypeNotFound("personality type with id %s not found", String.valueOf(personalityTypeID));
        }
        String requestToBeSend = String.format("Создай задание для человека с типом личности %s", personalityType.get()
            .getNameRU());

        MessageWithParammetersDAO requestToModel = new MessageWithParammetersDAO();

        requestToModel.setMessage(MessageDAO.builder()
            .role("system")
            .content(INIT_PROMPT)
            .build()
        );

        requestToModel.setMessage(MessageDAO.builder()
            .role("user")
            .content(requestToBeSend)
            .build()
        );

        String[] modelResponse = chatMessageProccessor.sendRequestToModel(requestToModel).split(": ");
        String taskTitle = modelResponse[0];
        String taskDesctiption = modelResponse[1];

        taskRepository.save(Task.builder()
            .title(taskTitle)
            .description(taskDesctiption)
            .personalityType(personalityType.get())
            .isAI(true)
            .build()
        );
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

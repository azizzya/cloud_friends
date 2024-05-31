package com.cloudcom2024.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloudcom2024.store.dtos.ChatMessageRequest;
import com.cloudcom2024.store.dtos.GigaChatAccessTockenResponse;
import com.cloudcom2024.store.models.Message;
import com.cloudcom2024.store.processors.ChatMessageProccessor;
import com.cloudcom2024.store.repositories.UserRepository;

@Service
public class GigaChatService {
    final private ChatMessageProccessor chatMessageProccessor;
    final private UserRepository userRepository;

    public GigaChatService(
        ChatMessageProccessor chatMessageProccessor,
        UserRepository userRepository
    ) {
        this.chatMessageProccessor = chatMessageProccessor;
        this.userRepository = userRepository;
    }

    public String getMessage(ChatMessageRequest chatMessageRequest) {
        GigaChatAccessTockenResponse token = chatMessageProccessor.getCurrentToken();
        if (token == null || token.isTokenExpired()) {
            chatMessageProccessor.updateToken();
        }

        return chatMessageProccessor.getMessage(chatMessageRequest);
    }

    public List<Message> getAllMessagesByUsername(String username) {
        return userRepository.findUserByUsername(username).get()
            .getMessages();
    }
}

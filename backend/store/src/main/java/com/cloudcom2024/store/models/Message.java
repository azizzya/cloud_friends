<<<<<<< HEAD
package com.cloudcom2024.store.models;

import com.cloudcom2024.store.daos.MessageDAO;
import com.cloudcom2024.store.dtos.MessageResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private long messageId;

    @Column(name = "role")
    private String role;
    
    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageDAO convertDAOMessage() {
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.setRole(role);
        messageDAO.setContent(message);
        return messageDAO;
    }

    public MessageResponse convertToMessageResponse() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage(message);
        messageResponse.setMessageId(messageId);
        messageResponse.setRole(role);
        return messageResponse;
    }
=======
package com.cloudcom2024.store.models;

import com.cloudcom2024.store.daos.MessageDAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private long messageId;

    @Column(name = "role")
    private String role;
    
    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageDAO convertDAOMessage() {
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.setRole(role);
        messageDAO.setContent(message);
        return messageDAO;
    }
>>>>>>> styles
}
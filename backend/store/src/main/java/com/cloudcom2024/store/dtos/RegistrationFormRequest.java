package com.cloudcom2024.store.dtos;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.cloudcom2024.store.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationFormRequest {
    @JsonIgnore
    final private PasswordEncoder passwordEncoder;

    public RegistrationFormRequest(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @NotEmpty(message = "username musn't be empty")
    @JsonProperty(value = "username")
    private String username;

    @NotEmpty(message = "firstname musn't be empty")
    @JsonProperty(value = "firstname")
    private String firstname;

    @NotEmpty(message = "lastname musn't be empty")
    @JsonProperty(value = "lastname")
    private String lastname;

    @JsonProperty(value = "fathername")
    private String fathername;

    @NotEmpty(message = "password musn't be empty")
    @JsonProperty(value = "password")
    private String password;

    public User convertToUser() {
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setFathername(fathername);
        user.setPassword(encodedPassword);
        return user;
    }
}
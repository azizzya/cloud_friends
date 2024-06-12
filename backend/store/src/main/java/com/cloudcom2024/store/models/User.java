package com.cloudcom2024.store.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.cloudcom2024.store.dtos.UserResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userID;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "fathername")
    private String fathername;

    @Column(name = "password")
    private String password;

    @Column(name = "coin_balance")
    private BigDecimal coinBalance;

    @Column(name = "coin_total_score")
    private BigDecimal coinTotalScore;

    @Column(name = "roles")
    private String roles;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<TaskDetails> taskDetails = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personality_type_id")
    private PersonalityType personalityType;

    public void setTaskDetail(TaskDetails taskDetail) {
        taskDetails.add(taskDetail);
    }

    public User(long userID) {
        this.userID = userID;
    }

    public UserResponse convertToUserResponse(String userProfileImage) {
        return UserResponse.builder()
            .userId(userID)
            .username(username)
            .firstname(firstname)
            .lastname(lastname)
            .fathername(fathername)
            .coinTotalScore(coinTotalScore)
            .profileImageName(userProfileImage)
            .coinBalance(coinBalance)
            .roles(roles)
            .email(email)
            .phoneNumber(phoneNumber)
            .build();
    }
}
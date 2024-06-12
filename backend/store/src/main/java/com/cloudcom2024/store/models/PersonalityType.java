package com.cloudcom2024.store.models;

import java.util.ArrayList;
import java.util.List;

import com.cloudcom2024.store.dtos.PersonalityTypeResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personality_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalityType {
    @Id
    @GeneratedValue
    @Column(name = "personality_type_id")
    private long personalityTypeID;

    @Column(name = "name_EN")
    private String nameEN;

    @Column(name = "name_RU")
    private String nameRU;

    public PersonalityType(long personalityTypeID) {
        this.personalityTypeID = personalityTypeID;
    }

    @OneToMany(
        mappedBy = "personalityType",
        fetch = FetchType.EAGER
    )
    private List<User> users = new ArrayList<>();

    @OneToMany(
        mappedBy = "personalityType",
        fetch = FetchType.EAGER
    )
    private List<Task> tasks = new ArrayList<>();

    public PersonalityType(String nameEN, String nameRU) {
        this.nameEN = nameEN;
        this.nameRU = nameRU;
    }
    
    public void addUser(User user) {
        users.add(user);
    }

    public PersonalityTypeResponse convertToPersonalityTypeResponse() {
        return PersonalityTypeResponse.builder()
            .personalityTypeID(personalityTypeID)
            .name(nameRU)
            .build();
    }
}

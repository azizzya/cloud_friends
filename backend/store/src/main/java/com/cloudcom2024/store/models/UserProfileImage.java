package com.cloudcom2024.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_profile_images")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileImage {
    @Id
    @GeneratedValue
    @Column(name = "user_profile_id") 
    private long userProfileID;

    @Column(name = "name")
    private String name;

    @Column(name = "user_profile_image_path")
    private String userProfileImagePath;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

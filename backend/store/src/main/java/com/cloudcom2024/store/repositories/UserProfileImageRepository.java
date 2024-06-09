package com.cloudcom2024.store.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloudcom2024.store.models.UserProfileImage;

@Repository
public interface UserProfileImageRepository extends CrudRepository<UserProfileImage, Long> {
    Optional<UserProfileImage> findByName(String userProfileImageName);

    @Query(
        value = "SELECT * FROM user_profile_images WHERE user_profile_id = ?1",
        nativeQuery = true
    )
    Optional<UserProfileImage> findImageByUserID(Long UserID);
} 
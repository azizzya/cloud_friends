package com.cloudcom2024.store.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloudcom2024.store.models.ItemImage;

@Repository
public interface ItemImageRepository extends CrudRepository<ItemImage, Long> {
    Optional<ItemImage> findByName(String imageItemImageName);

    @Query(
        value = "SELECT * FROM item_images WHERE item_id = ?1",
        nativeQuery = true
    )
    Optional<ItemImage> findImageByItemID(Long userID);
} 
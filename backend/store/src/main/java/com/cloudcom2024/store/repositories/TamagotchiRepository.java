package com.cloudcom2024.store.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloudcom2024.store.models.Tamagotchi;

@Repository
public interface TamagotchiRepository extends CrudRepository<Tamagotchi, Long> {
    @Query(
        value = "SELECT * FROM tamagotchi WHERE user_id = ?1",
        nativeQuery = true
    )
    Tamagotchi findTamagotchiByUserID(Long userID);
}

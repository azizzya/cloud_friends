package com.cloudcom2024.store.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloudcom2024.store.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(
        value = "SELECT * FROM users u WHERE u.username = ?1",
        nativeQuery = true
    )
    Optional<User> findUserByUsername(String username);

    @Query(
        value = "SELECT * FROM users ORDER BY coin_total_score DESC LIMIT 100",
        nativeQuery = true
    )
    List<User> getAllUsersSortByCoinBalanceDESCWithLimit100();

    List<User> findAll();
} 
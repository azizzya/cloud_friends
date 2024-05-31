package com.cloudcom2024.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cloudcom2024.store.models.Basket;

@Service
public interface BasketRepository extends CrudRepository <Basket, Long> {
    
} 
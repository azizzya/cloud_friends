package com.cloudcom2024.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloudcom2024.store.dtos.PersonalityTypeResponse;
import com.cloudcom2024.store.repositories.PersonalityTypeRepository;

@Service
public class PersonalityService {
    final private PersonalityTypeRepository personalityTypeRepository;

    public PersonalityService(
        PersonalityTypeRepository personalityTypeRepository
    ) {
        this.personalityTypeRepository = personalityTypeRepository;
    }

    public List<PersonalityTypeResponse> findAllPersonalities() {
        return personalityTypeRepository.findAll().stream()
            .map(personalityType -> personalityType.convertToPersonalityTypeResponse())
            .toList();
    }
}

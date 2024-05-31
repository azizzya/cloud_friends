package com.cloudcom2024.store.services;

import org.springframework.stereotype.Service;

import com.cloudcom2024.store.models.Tamagotchi;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.repositories.TamagotchiRepository;
import com.cloudcom2024.store.repositories.UserRepository;

@Service
public class TamagotchiService {
    final private UserRepository userRepository;
    final private TamagotchiRepository tamagotchiRepository;

    public TamagotchiService(
        UserRepository userRepository,
        TamagotchiRepository tamagotchiRepository
    ) {
        this.userRepository = userRepository;
        this.tamagotchiRepository = tamagotchiRepository;
    }

    public Tamagotchi getTamagotchiByUserName(String username) {
        User currentUser = userRepository.findUserByUsername(username).get();
        return tamagotchiRepository.findTamagotchiByUserID(currentUser.getUserID());
    }
}

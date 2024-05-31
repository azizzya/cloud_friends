package com.cloudcom2024.store;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cloudcom2024.store.models.Item;
import com.cloudcom2024.store.models.PersonalityType;
import com.cloudcom2024.store.models.Tamagotchi;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.repositories.ItemRespository;
import com.cloudcom2024.store.repositories.TamagotchiRepository;
import com.cloudcom2024.store.repositories.UserRepository;

import net.datafaker.Faker;

import java.util.List;
import java.util.Locale;


@Component
public class DatabaseLoader implements CommandLineRunner{
    final private ItemRespository itemRespository;
    final private UserRepository userRepository;
    final private TamagotchiRepository tamagotchiRepository;
    final private PasswordEncoder passwordEncoder;

    public DatabaseLoader(
        ItemRespository itemRespository,
        UserRepository userRepository,
        TamagotchiRepository tamagotchiRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.itemRespository = itemRespository;
        this.userRepository = userRepository;
        this.tamagotchiRepository = tamagotchiRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... strings) throws Exception {
        Faker faker = new Faker(new Locale("ru"));

        PersonalityType introvert = new PersonalityType("introvert");
        PersonalityType extrovert = new PersonalityType("extrovert");

        BigDecimal userCoinBalance = new BigDecimal(faker.number().numberBetween(1, 1000));
        User user = User.builder()
            .username("user")
            .firstname(faker.name().firstName())
            .lastname(faker.name().lastName())
            .password(passwordEncoder.encode("user"))
            .coinBalance(userCoinBalance)
            .coinTotalScore(userCoinBalance.add(new BigDecimal("100")))
            .roles("ROLE_USER")
            .email("user@mail.ru")
            .phoneNumber(faker.phoneNumber().phoneNumber())
            .personalityType(introvert)
            .build();

        BigDecimal adminCoinBalance = new BigDecimal(faker.number().numberBetween(1, 1000));
        User admin = User.builder()
            .username("admin")
            .firstname(faker.name().firstName())
            .lastname(faker.name().lastName())
            .password(passwordEncoder.encode("admin"))
            .coinBalance(adminCoinBalance)
            .coinTotalScore(adminCoinBalance.add(new BigDecimal("100")))
            .roles("ROLE_ADMIN")
            .email("admin@mail.ru")
            .phoneNumber(faker.phoneNumber().phoneNumber())
            .personalityType(extrovert)
            .build();

        userRepository.save(user);
        userRepository.save(admin);

        Tamagotchi tamagotchi1 = new Tamagotchi(user, faker.number().numberBetween(1, 3));
        Tamagotchi tamagotchi2 = new Tamagotchi(admin, faker.number().numberBetween(1, 3));

        tamagotchiRepository.save(tamagotchi1);
        tamagotchiRepository.save(tamagotchi2);

        List<Item> items = faker.<Item>collection(
            () -> Item.builder()
                .name(faker.device().modelName().toString())
                .description(faker.lorem().sentence(10))
                .price(new BigDecimal(faker.number().digit()))
                .category("Девайсы")
                .build()
        ).maxLen(10)
        .generate();

        itemRespository.saveAll(items);
    }
}
package com.cloudcom2024.store;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cloudcom2024.store.models.Item;
import com.cloudcom2024.store.models.ItemImage;
import com.cloudcom2024.store.models.PersonalityType;
import com.cloudcom2024.store.models.Tamagotchi;
import com.cloudcom2024.store.models.Task;
import com.cloudcom2024.store.models.TaskDetails;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.models.UserProfileImage;
import com.cloudcom2024.store.repositories.ItemImageRepository;
import com.cloudcom2024.store.repositories.ItemRespository;
import com.cloudcom2024.store.repositories.TamagotchiRepository;
import com.cloudcom2024.store.repositories.TaskDetailsRepository;
import com.cloudcom2024.store.repositories.TaskRepository;
import com.cloudcom2024.store.repositories.UserProfileImageRepository;
import com.cloudcom2024.store.repositories.UserRepository;

import lombok.extern.log4j.Log4j2;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Component
@Log4j2
public class DatabaseLoader implements CommandLineRunner{
    final private ItemRespository itemRespository;
    final private ItemImageRepository itemImageRepository;
    final private UserRepository userRepository;
    final private UserProfileImageRepository userProfileImageRepository;
    final private TamagotchiRepository tamagotchiRepository;
    final private TaskRepository taskRepository;
    final private TaskDetailsRepository taskDetailsRepository;
    final private PasswordEncoder passwordEncoder;

    @Value("${system.home}")
    private String SYSTEM_HOME;

    public DatabaseLoader(
        ItemRespository itemRespository,
        ItemImageRepository itemImageRepository,
        UserRepository userRepository,
        UserProfileImageRepository userProfileImageRepository,
        TamagotchiRepository tamagotchiRepository,
        TaskRepository taskRepository,
        TaskDetailsRepository taskDetailsRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.itemRespository = itemRespository;
        this.itemImageRepository = itemImageRepository;
        this.userRepository = userRepository;
        this.userProfileImageRepository = userProfileImageRepository;
        this.tamagotchiRepository = tamagotchiRepository;
        this.taskRepository = taskRepository;
        this.taskDetailsRepository = taskDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... strings) throws Exception {
        Faker faker = new Faker(new Locale("ru"));

        String ITEM_FOLDER_PATH = SYSTEM_HOME + "/Application/CloudCom/static/itemImages";
        String USER_PROFILE_FOLDER_PATH = SYSTEM_HOME + "/Application/CloudCom/static/userProfileImages";

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

        List<User> otherUsers = faker.<User>collection(
            () -> User.builder()
                .username(faker.internet().username())
                .coinTotalScore(new BigDecimal(faker.number().numberBetween(1, 1000)))
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .build()
        ).maxLen(2)
        .generate();

        userRepository.saveAll(otherUsers);

        List<User> allUsers = new ArrayList<>(otherUsers);
        allUsers.add(user);
        allUsers.add(admin);

        File userProfileImageDir = new File(USER_PROFILE_FOLDER_PATH);
        File[] userProfileImages = userProfileImageDir.listFiles();

        int counter1 = 0;
        for (File userProfileImage: userProfileImages) {
            String fileName = userProfileImage.getName(); 
            String filePath = USER_PROFILE_FOLDER_PATH + "/" + fileName;
            userProfileImageRepository.save(UserProfileImage.builder()
                .name(fileName)
                .userProfileImagePath(filePath)
                .user(allUsers.get(counter1))
                .build()
            );
            counter1++;
        }

        Tamagotchi tamagotchi1 = new Tamagotchi(user, faker.number().numberBetween(1, 3));
        Tamagotchi tamagotchi2 = new Tamagotchi(admin, faker.number().numberBetween(1, 3));

        tamagotchiRepository.save(tamagotchi1);
        tamagotchiRepository.save(tamagotchi2);

        List<Item> items = faker.<Item>collection(
            () -> Item.builder()
                .name(faker.device().modelName().toString())
                .description(faker.lorem().sentence(10))
                .price(new BigDecimal(faker.number().numberBetween(500, 3000)))
                .category("Остальное")
                .build()
        ).maxLen(6)
        .generate();

        itemRespository.saveAll(items);

        File itemImageDir = new File(ITEM_FOLDER_PATH);
        File[] itemImages = itemImageDir.listFiles();

        int counter = 0;
        for (File itemImage: itemImages) {
            String fileName = itemImage.getName(); 
            String filePath = ITEM_FOLDER_PATH + "/" + fileName;
            itemImageRepository.save(ItemImage.builder()
                .name(fileName)
                .itemImagePath(filePath)
                .item(items.get(counter))
                .build()
            );
            counter++;
        }

        taskRepository.save(Task.builder()
            .title("Покушать")
            .description("Выпей чаю")
            .build()
        );

        taskDetailsRepository.save(TaskDetails.builder()
            .taskDeadline(LocalDateTime.of(2024, 8, 9, 21, 53, 24))
            .coinReward(adminCoinBalance)
            .user(new User(1))
            .friend(new User(2))
            .task(new Task(1))
            .build()
        );

        taskDetailsRepository.save(TaskDetails.builder()
            .taskDeadline(LocalDateTime.of(2024, 8, 9, 21, 53, 24))
            .coinReward(adminCoinBalance)
            .user(new User(2))
            .friend(new User(1))
            .task(new Task(1))
            .build()
        );
    }
}
package com.cloudcom2024.store.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cloudcom2024.store.models.Item;
import com.cloudcom2024.store.models.ItemImage;
import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.models.UserProfileImage;
import com.cloudcom2024.store.repositories.ItemImageRepository;
import com.cloudcom2024.store.repositories.ItemRespository;
import com.cloudcom2024.store.repositories.UserProfileImageRepository;
import com.cloudcom2024.store.repositories.UserRepository;
import com.cloudcom2024.store.utils.ImageUtil;


@Service
public class ImageService {
    final private ItemImageRepository itemImageRepository;
    final private UserProfileImageRepository userProfileImageRepository;
    final private ItemRespository itemRespository;
    final private UserRepository userRepository;

    @Value("${system.home}")
    private String SYSTEM_HOME;

    public ImageService(
        ItemImageRepository itemImageRepository,
        UserProfileImageRepository userProfileImageRepository,
        ItemRespository itemRespository,
        UserRepository userRepository
    ) {
        this.itemImageRepository = itemImageRepository;
        this.userProfileImageRepository = userProfileImageRepository;
        this.itemRespository = itemRespository;
        this.userRepository = userRepository;
    }

    public void uploadItemImage(MultipartFile file, long itemID) throws IOException {
        String FOLDER_PATH = SYSTEM_HOME + "/Application/CloudCom/static/itemImages/";

        String filePath = FOLDER_PATH + file.getOriginalFilename();

        itemImageRepository.save(ItemImage.builder()
            .name(file.getOriginalFilename())
            .itemImagePath(filePath)
            .item(new Item(itemID))
            .build()
        );
        file.transferTo(new File(filePath));
    }

    public byte[] downloadItemImage(String fileName) throws IOException {
        Optional<ItemImage> itemImage = itemImageRepository.findByName(fileName);
        String filePath = itemImage.get().getItemImagePath();
        byte[] byteItemImage = Files.readAllBytes(new File(filePath).toPath());
        return byteItemImage;
    }

    public byte[] downloadUserProfileImage(String fileName) throws IOException {
        Optional<UserProfileImage> userProfileImage = userProfileImageRepository.findByName(fileName);
        String filePath = userProfileImage.get().getUserProfileImagePath();
        byte[] byteUserProfileImage = Files.readAllBytes(new File(filePath).toPath());
        return byteUserProfileImage;
    }
}

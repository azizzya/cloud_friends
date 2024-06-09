package com.cloudcom2024.store.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudcom2024.store.exceptions.ImageNotFoundException;
import com.cloudcom2024.store.exceptions.ItemImageAlreadyExistsException;
import com.cloudcom2024.store.exceptions.ItemNotFoundException;
import com.cloudcom2024.store.models.Item;
import com.cloudcom2024.store.models.ItemImage;
import com.cloudcom2024.store.models.UserProfileImage;
import com.cloudcom2024.store.repositories.ItemImageRepository;
import com.cloudcom2024.store.repositories.ItemRespository;
import com.cloudcom2024.store.repositories.UserProfileImageRepository;


@Service
public class ImageService {
    final private ItemImageRepository itemImageRepository;
    final private UserProfileImageRepository userProfileImageRepository;
    final private ItemRespository itemRespository;

    @Value("${system.home}")
    private String SYSTEM_HOME;

    public ImageService(
        ItemImageRepository itemImageRepository,
        UserProfileImageRepository userProfileImageRepository,
        ItemRespository itemRespository
    ) {
        this.itemImageRepository = itemImageRepository;
        this.itemRespository = itemRespository;
        this.userProfileImageRepository = userProfileImageRepository;
    }

    public void uploadItemImage(MultipartFile file, long itemID) throws IOException {
        Optional<Item> item = itemRespository.findById(itemID);
        if (!item.isPresent()) {
            throw new ItemNotFoundException("предмет не найден", itemID);
        }

        Optional<ItemImage> itemImage = itemImageRepository.findByName(file.getOriginalFilename());
        if (!itemImage.isPresent()) {
            String filename = file.getOriginalFilename();
            throw new ItemImageAlreadyExistsException("картика с таким названием уже существует", filename);
        }

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

    public byte[] downloadItemImage(String filename) throws IOException {
        Optional<ItemImage> itemImage = itemImageRepository.findByName(filename);
        if (!itemImage.isPresent()) {
            throw new ImageNotFoundException("картинка не найдена", filename);
        }
        String filePath = itemImage.get().getItemImagePath();
        byte[] byteItemImage = Files.readAllBytes(new File(filePath).toPath());
        return byteItemImage;
    }

    public byte[] downloadUserProfileImage(String filename) throws IOException {
        Optional<UserProfileImage> userProfileImage = userProfileImageRepository.findByName(filename);
        if (!userProfileImage.isPresent()) {
            throw new ImageNotFoundException("картинка не найдена", filename);
        }
        String filePath = userProfileImage.get().getUserProfileImagePath();
        byte[] byteUserProfileImage = Files.readAllBytes(new File(filePath).toPath());
        return byteUserProfileImage;
    }
}

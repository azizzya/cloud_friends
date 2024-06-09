package com.cloudcom2024.store.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.fileupload.MultipartStream.ItemInputStream;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcom2024.store.dtos.ItemResponse;
import com.cloudcom2024.store.models.Item;
import com.cloudcom2024.store.models.ItemImage;
import com.cloudcom2024.store.repositories.ItemImageRepository;
import com.cloudcom2024.store.repositories.ItemRespository;

@Service
public class StoreService {
    final private ItemRespository itemRespository;
    final private ItemImageRepository imageRepository;

    StoreService(
        ItemRespository itemRespository,
        ItemImageRepository imageRepository 
    ) {
        this.itemRespository = itemRespository;
        this.imageRepository = imageRepository;
    }

    @Transactional
    public List<ItemResponse> getAllItems() {
        List<Item> items = itemRespository.findAll();
        
        List<ItemResponse> itemsReposponse = new ArrayList<>();
        for (Item item: items) {
            Optional<ItemImage> image = imageRepository.findImageByItemID(item.getItemID());
            ItemResponse itemResponse = item.convertToItemResponse("");
            if (image.isPresent()) {
                itemResponse = item.convertToItemResponse(image.get().getName());
            }
            itemsReposponse.add(itemResponse);
        }
        return itemsReposponse;

    }

    public Optional<Item> getItemByItemId(Long itemId) {
        return itemRespository.findById(itemId);
    }
    
}

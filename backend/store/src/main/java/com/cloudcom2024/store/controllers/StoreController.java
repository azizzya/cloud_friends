package com.cloudcom2024.store.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudcom2024.store.dtos.ItemResponse;
import com.cloudcom2024.store.services.ImageService;
import com.cloudcom2024.store.services.StoreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Tag(name = "Магазин", description = "Для операций связанных с магазином")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/store")
public class StoreController {
    final private StoreService storeService;
    final private ImageService imageService;

    StoreController(
        StoreService storeService,
        ImageService imageService
    ) {
        this.storeService = storeService;
        this.imageService = imageService;
    }
    
    @GetMapping("/items")
    @Operation(description = "Взять все предметы, находящиеся в магазине")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    public List<ItemResponse> getAllItems() {
        return storeService.getAllItems();
    }

    @GetMapping("items/images/{imageName}")
    public ResponseEntity<byte[]> getItemImage(@PathVariable String imageName) throws IOException {
        byte[] image = imageService.downloadItemImage(imageName);
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.IMAGE_JPEG)
            .body(image);
    }

    @PostMapping("items/{itemID}/image")
    public void uploadItemImage(
        @RequestParam("image") MultipartFile file,
        @PathVariable long itemID
    ) throws IOException {
        imageService.uploadItemImage(file, itemID);
    }
    
    
}

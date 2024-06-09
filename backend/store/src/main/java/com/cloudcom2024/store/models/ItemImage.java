package com.cloudcom2024.store.models;

import org.springframework.cloud.openfeign.CollectionFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_images")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemImage {
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private long imageID; 

    @Column(name = "name")
    private String name;

    //@Lob
    //@Column(name = "picture_byte", length = 5000) 
    //private byte[] image;

    @Column(name = "item_image_path")
    private String itemImagePath;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;
}

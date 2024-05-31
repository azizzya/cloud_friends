package com.cloudcom2024.store.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.cloudcom2024.store.dtos.ItemResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "category", nullable = false)
    private String category;

    @ManyToMany(mappedBy = "items")
    private List<Basket> baskets = new ArrayList<>();

    public void setBasket(Basket basket) {
        baskets.add(basket);
    }

    public ItemResponse convertToItemRequest() {
        return ItemResponse.builder()
            .itemId(itemId)
            .name(name)
            .description(description)
            .price(price)
            .category(category)
            .build();
    }
}

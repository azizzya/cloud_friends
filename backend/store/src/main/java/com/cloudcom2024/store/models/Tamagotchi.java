package com.cloudcom2024.store.models;

import com.cloudcom2024.store.dtos.TamagotchiResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tamagotchi")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tamagotchi {
    @Id
    @GeneratedValue
    @Column(name = "tamagothi_id")
    private long tamagothieId;

    @NotNull
    @Column(name = "boost")
    private int boost;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Tamagotchi(User user, int boost) {
        this.user = user;
        this.boost = boost;
    }

    public TamagotchiResponse convertToTamagotchiResponse() {
        TamagotchiResponse tamagotchiResponse = new TamagotchiResponse();
        tamagotchiResponse.setHappiness(boost);
        tamagotchiResponse.setTamagitchiID(tamagothieId);

        return tamagotchiResponse;
    }
}

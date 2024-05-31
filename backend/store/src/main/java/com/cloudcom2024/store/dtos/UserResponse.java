package com.cloudcom2024.store.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("username")
    private String username;
    
    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("fathername")
    private String fathername;

    @JsonProperty("coin_balance")
    private BigDecimal coinBalance;

    @JsonProperty("roles")
    private String roles;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("qr_code")
    private byte[] qrCode;
}

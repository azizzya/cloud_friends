package com.cloudcom2024.store.proxies;


import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cloudcom2024.store.configs.FeignConfig;
import com.cloudcom2024.store.daos.AccessTokenDAO;
import com.cloudcom2024.store.dtos.GigaChatAccessTockenResponse;

import feign.Headers;

@FeignClient(
    name = "gigaChatGetToken",
    url = "https://ngw.devices.sberbank.ru:9443/api/v2/oauth",
    configuration = FeignConfig.class
)
public interface GigaChatGetTokenProxy {
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers({
        "Content-Type: application/x-www-form-urlencoded",
        "Accept: application/json"
    })
    public GigaChatAccessTockenResponse createAccessTocken(
        @RequestHeader Map<String, Object> headers,
        @RequestBody AccessTokenDAO scope
    );
} 
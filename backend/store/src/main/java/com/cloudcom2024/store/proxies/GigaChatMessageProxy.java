package com.cloudcom2024.store.proxies;


import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cloudcom2024.store.configs.FeignConfig;
import com.cloudcom2024.store.daos.MessageResponseDAO;
import com.cloudcom2024.store.daos.MessageWithParammetersDAO;

import feign.Headers;

@FeignClient(
    name = "gigaChatMessage",
    url = "https://gigachat.devices.sberbank.ru/api/v1",
    configuration = FeignConfig.class
)
public interface GigaChatMessageProxy {
    @PostMapping(path = "/chat/completions")
    @Headers({
        "Content-Type: application/json",
        "Accept: application/json"
    })
    public MessageResponseDAO sendMessage(
        @RequestHeader Map<String, Object> headers,
        @RequestBody MessageWithParammetersDAO message
    );
} 

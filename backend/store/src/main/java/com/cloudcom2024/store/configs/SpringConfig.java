package com.cloudcom2024.store.configs;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableFeignClients(basePackages = "com.cloudcom2024.store.proxies")
public class SpringConfig {
    
}

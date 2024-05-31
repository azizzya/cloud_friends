package com.cloudcom2024.store.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
    info = @Info(title = "Cloud friends API", description = "API for Cloudcom project"),
    security = {
        @SecurityRequirement(name = "Basic HTTP Authorization")
    }
)
@SecurityScheme(name = "Authorization", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class OpenAPIConfig {
    
}

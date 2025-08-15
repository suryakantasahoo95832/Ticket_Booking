package com.surya.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "IRCTC REST-API",
        version = "1.0",
        description = "API Documentation for My Project"
    )
)
public class OpenApiConfig {
}

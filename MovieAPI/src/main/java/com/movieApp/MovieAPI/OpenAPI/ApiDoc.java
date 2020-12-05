package com.movieApp.MovieAPI.OpenAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Movie API", version = "3.0.1", description = "REST API for Movie Info"))
public class ApiDoc {
}

package br.com.occurrence.api.app.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    private static final String BEARER_AUTH = "bearerAuth";

    @Bean
    public OpenAPI customizeOpenAPI() {
        return new OpenAPI()
                .info(info())
                .addSecurityItem(securityRequirement())
                .components(components());
    }

    public static Info info() {
        return new Info()
            .title("Ticket api")
            .description("Responsável pelo módulo de tickets");
    }

    public static SecurityRequirement securityRequirement() {
        return new SecurityRequirement()
            .addList(BEARER_AUTH);
    }

    public static SecurityScheme securityScheme() {
        return new SecurityScheme()
            .name(BEARER_AUTH)
            .type(SecurityScheme.Type.HTTP)
            .bearerFormat("JWT");
    }

    public static Components components() {
        return new Components()
            .addSecuritySchemes(BEARER_AUTH, securityScheme());
    }

}

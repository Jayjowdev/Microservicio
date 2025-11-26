package com.microservicio.membresia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI membresiaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Membresías - Workean")
                        .description("API REST para gestión de membresías y suscripciones")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo Workean")
                                .email("contacto@workean.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}

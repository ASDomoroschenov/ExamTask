package ru.sberp.javaseniortask.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Java Senior Task",
        description = "API системы",
        version = "1.0.0",
        contact = @Contact(
            name = "Доморощенов Александр",
            email = "ASDomoroschenov@mail.ru"
        )
    )
)
public class OpenApiConfig {

}

package ru.sberp.javaseniortask.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

  @Schema(
      name = "name",
      description = "Имя пользователя",
      type = "String"
  )
  @NotBlank(message = "Имя пользователя не может быть пустым")
  @NotNull(message = "Имя пользователя должно быть указано")
  private String name;

  @Schema(
      name = "password",
      description = "Пароль",
      type = "String"
  )
  @NotBlank(message = "Пароль не может быть пустым")
  @NotNull(message = "Пароль должен быть указан")
  private String password;
}
package ru.sberp.javaseniortask.dto.request.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

  @Schema(
      name = "id",
      description = "Идентификатор пользователя",
      type = "Long",
      minimum = "1",
      maximum = "999999999999"
  )
  @NotNull(message = "Идентификатор пользователя должен быть указан")
  private Long id;

  @Schema(
      name = "name",
      description = "Имя пользователя",
      type = "String",
      minLength = 1,
      maxLength = 500
  )
  @Size(min = 1, max = 500, message = "Длина имени от 1 до 500 символов")
  @NotBlank(message = "Имя не должно быть пустым")
  @NotNull(message = "Имя должно быть указано")
  private String name;

  @Schema(
      name = "dateOfBirth",
      description = "Дата рождения",
      type = "LocalDate",
      pattern = "^\\d{2}.\\d{2}.\\d{4}$"
  )
  @JsonFormat(shape = Shape.STRING, pattern = "dd.MM.yyyy")
  @Pattern(regexp = "^\\d{2}.\\d{2}.\\d{4}$", message = "Неверный формат даты")
  private LocalDate dateOfBirth;

  @Schema(
      name = "password",
      description = "Пароль",
      type = "String",
      minLength = 8,
      maxLength = 500
  )
  @Size(min = 8, max = 500, message = "Длина пароля от 8 до 500 символов")
  @NotBlank(message = "Пароль не должен быть пустым")
  @NotNull(message = "Пароль должен быть указан")
  private String password;
}

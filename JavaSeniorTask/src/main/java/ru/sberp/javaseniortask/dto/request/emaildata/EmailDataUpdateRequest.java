package ru.sberp.javaseniortask.dto.request.emaildata;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class EmailDataUpdateRequest {

  @Schema(
      name = "id",
      description = "Идентификатор почты",
      type = "Long",
      minimum = "1",
      maximum = "999999999999"
  )
  @Min(value = 1L, message = "Идентификатор почты не может быть меньше 1")
  @Max(value = 999999999999L, message = "Идентификатор почты не может быть больше 999999999999")
  @NotNull(message = "Идентификатор почты должен быть указан")
  private Long id;

  @Schema(
      name = "userId",
      description = "Идентификатор пользователя",
      type = "Long",
      minimum = "1",
      maximum = "999999999999"
  )
  @Min(value = 1L, message = "Идентификатор пользователя не может быть меньше 1")
  @Max(value = 999999999999L, message = "Идентификатор пользователя не может быть больше 999999999999")
  @NotNull(message = "Идентификатор пользователя должен быть указан")
  private Long userId;

  @Schema(
      name = "email",
      description = "Почта",
      type = "String",
      minLength = 1,
      maxLength = 500
  )
  @Size(min = 1, max = 500, message = "Длина почты от 1 до 500 символов")
  @NotBlank(message = "Почта не должна быть пустой")
  @NotNull(message = "Почта должна быть указана")
  private String email;
}

package ru.sberp.javaseniortask.dto.request.phonedata;

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
public class PhoneDataUpdateRequest {

  @Schema(
      name = "id",
      description = "Идентификатор телефона",
      type = "Long",
      minimum = "1",
      maximum = "999999999999"
  )
  @Min(value = 1L, message = "Идентификатор телефона не может быть меньше 1")
  @Max(value = 999999999999L, message = "Идентификатор телефона не может быть больше 999999999999")
  @NotNull(message = "Идентификатор телефона должен быть указан")
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
      name = "phone",
      description = "Номер телефона",
      type = "String",
      minLength = 1,
      maxLength = 13
  )
  @Size(min = 1, max = 13, message = "Номер телефона должен содержать от 1 до 13 цифр")
  @NotNull(message = "Номер телефона должен быть указан")
  @NotBlank(message = "Номер телефона не может быть пустым")
  private String phone;
}

package ru.sberp.javaseniortask.dto.response.user;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
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
public class UserResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = -4439114469417994311L;

  @Schema(
      name = "id",
      description = "Идентификатор пользователя",
      type = "Long",
      minimum = "1",
      maximum = "999999999999"
  )
  private Long id;

  @Schema(
      name = "name",
      description = "Имя пользователя",
      type = "String",
      minLength = 1,
      maxLength = 500
  )
  private String name;

  @Schema(
      name = "dateOfBirth",
      description = "Дата рождения",
      type = "LocalDate",
      pattern = "^\\d{2}.\\d{2}.\\d{4}$"
  )
  private LocalDate dateOfBirth;

  @Schema(
      name = "password",
      description = "Пароль",
      type = "String",
      minLength = 8,
      maxLength = 500
  )
  private String password;
}

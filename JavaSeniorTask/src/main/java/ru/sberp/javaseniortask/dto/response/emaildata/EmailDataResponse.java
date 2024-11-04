package ru.sberp.javaseniortask.dto.response.emaildata;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class EmailDataResponse {

  @Schema(
      name = "id",
      description = "Идентификатор почты",
      type = "Long",
      minimum = "1",
      maximum = "999999999999"
  )
  private Long id;

  @Schema(
      name = "userId",
      description = "Идентификатор пользователя",
      type = "Long",
      minimum = "1",
      maximum = "999999999999"
  )
  private Long userId;

  @Schema(
      name = "email",
      description = "Почта",
      type = "String",
      minLength = 1,
      maxLength = 500
  )
  private String email;
}

package ru.sberp.javaseniortask.dto.response.phonedata;

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
public class PhoneDataResponse {

  @Schema(
      name = "id",
      description = "Идентификатор телефона",
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
      name = "phone",
      description = "Номер телефона",
      type = "String",
      minLength = 1,
      maxLength = 13
  )
  private String phone;
}

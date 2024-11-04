package ru.sberp.javaseniortask.dto.response.account;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
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
public class AccountResponse {

  @Schema(
      name = "id",
      description = "Идентификатор аккаунта",
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
      name = "balance",
      description = "Баланс пользователя",
      type = "BigDecimal",
      minimum = "0",
      maximum = "999999999999"
  )
  private BigDecimal balance;
}

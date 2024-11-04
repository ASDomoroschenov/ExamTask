package ru.sberp.javaseniortask.dto.request.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class AccountCreateRequest {

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
      name = "balance",
      description = "Баланс пользователя",
      type = "BigDecimal",
      minimum = "0",
      maximum = "999999999999"
  )
  @Min(value = 0L, message = "Баланс не может быть меньше 0")
  @Max(value = 999999999999L, message = "Баланс не может быть больше 999999999999")
  @NotNull(message = "Баланс должен быть указан")
  private BigDecimal balance;
}

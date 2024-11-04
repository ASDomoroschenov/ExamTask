package ru.sberp.javaseniortask.security.dto;

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
public class JwtAuthenticationResponse {

  @Schema(
      name = "token",
      description = "JWT Токен",
      type = "String"
  )
  private String token;
}
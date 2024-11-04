package ru.sberp.javaseniortask.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import ru.sberp.javaseniortask.security.dto.JwtAuthenticationResponse;
import ru.sberp.javaseniortask.security.dto.SignInRequest;
import ru.sberp.javaseniortask.security.dto.SignUpRequest;

@Tag(name = "Аутентификация")
public interface AuthenticationController {

  @Operation(
      summary = "Регистрация пользователя",
      description = "Регистрация пользователя",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешная регистрация пользователя",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = JwtAuthenticationResponse.class)
              )
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Ошибка на стороне сервиса",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = InternalServerError.class)
              )
          )
      }
  )
  @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Запрос на регистрацию",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = SignUpRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса регистрацию",
                  value = """
                      {
                        "name": "Alexandr",
                        "password": "password"
                      }
                      """
              )
          }
      )
  )
  @PostMapping("/sign-up")
  JwtAuthenticationResponse signUp(
      @RequestBody @Valid SignUpRequest request);


  @Operation(
      summary = "Авторизация пользователя",
      description = "Авторизация пользователя",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешная авторизация пользователя",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = JwtAuthenticationResponse.class)
              )
          ),
          @ApiResponse(
              responseCode = "403",
              description = "Пользователь не найден",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Unauthorized.class)
              )
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Ошибка на стороне сервиса",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = InternalServerError.class)
              )
          )
      }
  )
  @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Запрос на авторизацию",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = SignUpRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса авторизацию",
                  value = """
                      {
                        "name": "Alexandr",
                        "password": "password"
                      }
                      """
              )
          }
      )
  )
  @PostMapping("/sign-in")
  JwtAuthenticationResponse signIn(
      @RequestBody @Valid SignInRequest request);
}
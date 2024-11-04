package ru.sberp.javaseniortask.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import ru.sberp.javaseniortask.dto.request.account.AccountCreateRequest;
import ru.sberp.javaseniortask.dto.request.account.AccountUpdateRequest;
import ru.sberp.javaseniortask.dto.response.account.AccountResponse;
import ru.sberp.javaseniortask.exception.ExceptionErrorMessage;

@Tag(
    name = "Контроллер по управлению аккаунтами",
    description = "Позволяет управлять аккаунтами"
)
public interface AccountController {

  @Operation(
      summary = "Создание аккаунта",
      description = "Создание аккаунта",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное создание аккаунта",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AccountResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "balance": 0.0
                              }
                              """
                      )
                  }
              )
          ),
          @ApiResponse(
              responseCode = "400",
              description = "Неверный формат запроса",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = BadRequest.class)
              )
          ),
          @ApiResponse(
              responseCode = "422",
              description = "Переданы неверные данные",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ExceptionErrorMessage.class),
                  examples = {
                      @ExampleObject(
                          name = "Ответ с ошибкой",
                          description = "Пользователь получил ошибку",
                          value = """
                              {
                                "status": "422 UNPROCESSABLE_ENTITY",
                                "error": "Сообщение об ошибке"
                              }
                              """
                      )
                  }
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
      description = "Запрос на создание аккаунта",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = AccountCreateRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса на создание аккаунта",
                  value = """
                      {
                        "userId": 1,
                        "balance": 0.0
                      }
                      """
              )
          }
      )
  )
  @PostMapping("/create")
  ResponseEntity<AccountResponse> createAccount(
      @RequestBody @Valid AccountCreateRequest request);

  @Operation(
      summary = "Обновление информации об аккаунте",
      description = "Обновление информации об аккаунте",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное обновление информации об аккаунте",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AccountResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "balance": 0.0
                              }
                              """
                      )
                  }
              )
          ),
          @ApiResponse(
              responseCode = "400",
              description = "Неверный формат запроса",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = BadRequest.class)
              )
          ),
          @ApiResponse(
              responseCode = "422",
              description = "Переданы неверные данные",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ExceptionErrorMessage.class),
                  examples = {
                      @ExampleObject(
                          name = "Ответ с ошибкой",
                          description = "Пользователь получил ошибку",
                          value = """
                              {
                                "status": "422 UNPROCESSABLE_ENTITY",
                                "error": "Сообщение об ошибке"
                              }
                              """
                      )
                  }
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
      description = "Запрос на обновление информации об аккаунте",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = AccountUpdateRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса на обновление информации об аккаунте",
                  value = """
                      {
                        "id": 1,
                        "userId": 1,
                        "balance": 0.0
                      }
                      """
              )
          }
      )
  )
  @PutMapping("/update")
  ResponseEntity<AccountResponse> updateAccount(
      @RequestBody @Valid AccountUpdateRequest request);

  @Operation(
      summary = "Получение аккаунта по идентификатору",
      description = "Получение аккаунта по идентификатору",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное получение информации об аккаунте",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AccountResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "balance": 0.0
                              }
                              """
                      )
                  }
              )
          ),
          @ApiResponse(
              responseCode = "422",
              description = "Переданы неверные данные",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ExceptionErrorMessage.class),
                  examples = {
                      @ExampleObject(
                          name = "Ответ с ошибкой",
                          description = "Пользователь получил ошибку",
                          value = """
                              {
                                "status": "422 UNPROCESSABLE_ENTITY",
                                "error": "Сообщение об ошибке"
                              }
                              """
                      )
                  }
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
  @GetMapping("/get")
  ResponseEntity<AccountResponse> getAccount(
      @Parameter(
          name = "Идентификатор аккаунта",
          required = true,
          examples = @ExampleObject(
              name = "Пример идентификатора аккаунта",
              value = "1"
          )
      )
      @RequestParam("id") Long id);


  @Operation(
      summary = "Удаление аккаунта по идентификатору",
      description = "Удаление аккаунта по идентификатору",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное удаление информации об аккаунте",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AccountResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "balance": 0.0
                              }
                              """
                      )
                  }
              )
          ),
          @ApiResponse(
              responseCode = "422",
              description = "Переданы неверные данные",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ExceptionErrorMessage.class),
                  examples = {
                      @ExampleObject(
                          name = "Ответ с ошибкой",
                          description = "Пользователь получил ошибку",
                          value = """
                              {
                                "status": "422 UNPROCESSABLE_ENTITY",
                                "error": "Сообщение об ошибке"
                              }
                              """
                      )
                  }
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
  @DeleteMapping("/delete")
  ResponseEntity<AccountResponse> deleteAccount(
      @Parameter(
          name = "Идентификатор аккаунта",
          required = true,
          examples = @ExampleObject(
              name = "Пример идентификатора аккаунта",
              value = "1"
          )
      )
      @RequestParam("id") Long id);
}

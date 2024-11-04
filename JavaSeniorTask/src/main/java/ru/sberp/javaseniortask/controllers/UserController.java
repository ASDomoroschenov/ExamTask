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
import ru.sberp.javaseniortask.dto.request.user.UserCreateRequest;
import ru.sberp.javaseniortask.dto.request.user.UserSearchFilter;
import ru.sberp.javaseniortask.dto.request.user.UserUpdateRequest;
import ru.sberp.javaseniortask.dto.response.user.UserResponse;
import ru.sberp.javaseniortask.exception.ExceptionErrorMessage;

@Tag(
    name = "Контроллер по управлению пользователями",
    description = "Позволяет управлять пользователями"
)
public interface UserController {

  @Operation(
      summary = "Создание пользователя",
      description = "Создание пользователя",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное создание пользователя",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "name": "Alexandr",
                                "dateOfBirth": "2024-11-04",
                                "password": "password"
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
      description = "Запрос на создание пользователя",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = UserCreateRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса на создание пользователя",
                  value = """
                      {
                        "name": "Alexandr",
                        "dateOfBirth": "2024.11.04",
                        "password": "password",
                        "balance": 0
                      }
                      """
              )
          }
      )
  )
  @PostMapping("/create")
  ResponseEntity<UserResponse> createUser(
      @RequestBody @Valid UserCreateRequest request);

  @Operation(
      summary = "Обновление информации о пользователе",
      description = "Обновление информации о пользователе",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное обновление информации о пользователе",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "name": "Alexandr",
                                "dateOfBirth": "2024-11-04",
                                "password": "password"
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
      description = "Запрос на обновление информации о пользователе",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = UserUpdateRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса на обновление информации о пользователе",
                  value = """
                      {
                        "id": 1,
                        "name": "Alexandr",
                        "dateOfBirth": "2024.11.04",
                        "password": "password"
                      }
                      """
              )
          }
      )
  )
  @PutMapping("/update")
  ResponseEntity<UserResponse> updateUser(
      @RequestBody @Valid UserUpdateRequest request);

  @Operation(
      summary = "Получение пользователя по идентификатору",
      description = "Получение пользователя по идентификатору",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное получение информации о пользователе",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "name": "Alexandr",
                                "dateOfBirth": "2024-11-04",
                                "password": "password"
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
  ResponseEntity<UserResponse> getUser(
      @Parameter(
          name = "Идентификатор пользователя",
          required = true,
          examples = @ExampleObject(
              name = "Пример идентификатора пользователя",
              value = "1"
          )
      )
      @RequestParam("id") Long id);


  @Operation(
      summary = "Удаление пользователя по идентификатору",
      description = "Удаление пользователя по идентификатору",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное удаление информации о пользователе",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "name": "Alexandr",
                                "dateOfBirth": "2024-11-04",
                                "password": "password"
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
  ResponseEntity<UserResponse> deleteUser(
      @Parameter(
          name = "Идентификатор пользователя",
          required = true,
          examples = @ExampleObject(
              name = "Пример идентификатора пользователя",
              value = "1"
          )
      )
      @RequestParam("id") Long id);

  @GetMapping("/search")
  ResponseEntity<List<UserResponse>> searchUser(
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "10") int size,
      @RequestBody @Valid UserSearchFilter filter);
}

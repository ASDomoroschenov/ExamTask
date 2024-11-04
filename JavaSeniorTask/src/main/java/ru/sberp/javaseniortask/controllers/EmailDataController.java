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
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.emaildata.EmailDataResponse;
import ru.sberp.javaseniortask.exception.ExceptionErrorMessage;

@Tag(
    name = "Контроллер по управлению почтами",
    description = "Позволяет управлять почтами"
)
public interface EmailDataController {

  @Operation(
      summary = "Создание почты",
      description = "Создание почты",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное создание почты",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = EmailDataResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "email": "ASDomoroschenov@mail.ru"
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
      description = "Запрос на создание почты",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = EmailDataCreateRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса на создание почты",
                  value = """
                      {
                        "userId": 1,
                        "email": "ASDomoroschenov@mail.ru"
                      }
                      """
              )
          }
      )
  )
  @PostMapping("/create")
  ResponseEntity<EmailDataResponse> createEmailData(
      @RequestBody @Valid EmailDataCreateRequest request);

  @Operation(
      summary = "Обновление информации о почте",
      description = "Обновление информации о почте",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное обновление информации о почте",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = EmailDataResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "email": "ASDomoroschenov@mail.ru"
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
      description = "Запрос на обновление информации о почте",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = EmailDataUpdateRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса на обновление информации о почте",
                  value = """
                      {
                        "id": 1,
                        "userId": 1,
                        "email": "ASDomoroschenov@mail.ru"
                      }
                      """
              )
          }
      )
  )
  @PutMapping("/update")
  ResponseEntity<EmailDataResponse> updateEmailData(
      @RequestBody @Valid EmailDataUpdateRequest request);

  @Operation(
      summary = "Получение почты по идентификатору",
      description = "Получение почты по идентификатору",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное получение информации о почте",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = EmailDataResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "email": "ASDomoroschenov@mail.ru"
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
  ResponseEntity<EmailDataResponse> getEmailData(
      @Parameter(
          name = "Идентификатор почты",
          required = true,
          examples = @ExampleObject(
              name = "Пример идентификатора почты",
              value = "1"
          )
      )
      @RequestParam("id") Long id);


  @Operation(
      summary = "Удаление почты по идентификатору",
      description = "Удаление почты по идентификатору",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное удаление информации о почте",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = EmailDataResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "email": "ASDomoroschenov@mail.ru"
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
  ResponseEntity<EmailDataResponse> deleteEmailData(
      @Parameter(
          name = "Идентификатор почты",
          required = true,
          examples = @ExampleObject(
              name = "Пример идентификатора почты",
              value = "1"
          )
      )
      @RequestParam("id") Long id);
}

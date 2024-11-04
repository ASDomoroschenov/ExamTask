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
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.phonedata.PhoneDataResponse;
import ru.sberp.javaseniortask.exception.ExceptionErrorMessage;

@Tag(
    name = "Контроллер по управлению телефонами",
    description = "Позволяет управлять телефонами"
)
public interface PhoneDataController {

  @Operation(
      summary = "Создание телефона",
      description = "Создание телефона",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное создание телефона",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = PhoneDataResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "phone": "89687175030"
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
      description = "Запрос на создание телефона",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = PhoneDataCreateRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса на создание телефона",
                  value = """
                      {
                        "userId": 1,
                        "phone": "89687175030"
                      }
                      """
              )
          }
      )
  )
  @PostMapping("/create")
  ResponseEntity<PhoneDataResponse> createPhoneData(
      @RequestBody @Valid PhoneDataCreateRequest request);

  @Operation(
      summary = "Обновление информации о телефоне",
      description = "Обновление информации о телефоне",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное обновление информации о телефоне",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = PhoneDataResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "phone": "89687175030"
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
      description = "Запрос на обновление информации о телефоне",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = PhoneDataUpdateRequest.class),
          examples = {
              @ExampleObject(
                  name = "Пример запроса на обновление информации о телефоне",
                  value = """
                      {
                        "id": 1,
                        "userId": 1,
                        "phone": "89687175030"
                      }
                      """
              )
          }
      )
  )
  @PutMapping("/update")
  ResponseEntity<PhoneDataResponse> updatePhoneData(
      @RequestBody @Valid PhoneDataUpdateRequest request);

  @Operation(
      summary = "Получение телефона по идентификатору",
      description = "Получение телефона по идентификатору",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное получение информации о телефоне",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = PhoneDataResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "phone": "89687175030"
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
  ResponseEntity<PhoneDataResponse> getPhoneData(
      @Parameter(
          name = "Идентификатор телефона",
          required = true,
          examples = @ExampleObject(
              name = "Пример идентификатора телефона",
              value = "1"
          )
      )
      @RequestParam("id") Long id);


  @Operation(
      summary = "Удаление телефона по идентификатору",
      description = "Удаление телефона по идентификатору",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Успешное удаление информации о телефоне",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = PhoneDataResponse.class),
                  examples = {
                      @ExampleObject(
                          name = "Пример успешного ответа",
                          description = "Пользователь получил успешный ответ",
                          value = """
                              {
                                "id": 1,
                                "userId": 1,
                                "phone": "89687175030"
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
  ResponseEntity<PhoneDataResponse> deletePhoneData(
      @Parameter(
          name = "Идентификатор телефона",
          required = true,
          examples = @ExampleObject(
              name = "Пример идентификатора телефона",
              value = "1"
          )
      )
      @RequestParam("id") Long id);
}

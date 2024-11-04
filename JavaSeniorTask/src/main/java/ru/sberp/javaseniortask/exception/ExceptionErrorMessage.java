package ru.sberp.javaseniortask.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionErrorMessage {

  private HttpStatus status;

  private String error;
}

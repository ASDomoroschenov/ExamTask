package ru.sberp.javaseniortask.controllers.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberp.javaseniortask.controllers.AuthenticationController;
import ru.sberp.javaseniortask.security.dto.JwtAuthenticationResponse;
import ru.sberp.javaseniortask.security.dto.SignInRequest;
import ru.sberp.javaseniortask.security.dto.SignUpRequest;
import ru.sberp.javaseniortask.security.services.AuthenticationService;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationControllerImpl implements AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/sign-up")
  public JwtAuthenticationResponse signUp(SignUpRequest request) {
    log.info("[auth.sign-up] Request: {}", request);
    JwtAuthenticationResponse response = authenticationService.signUp(request);
    log.info("[auth.sign-up] Response: {}", response);
    return response;
  }

  @PostMapping("/sign-in")
  public JwtAuthenticationResponse signIn(SignInRequest request) {
    log.info("[auth.sign-in] Request: {}", request);
    JwtAuthenticationResponse response = authenticationService.signIn(request);
    log.info("[auth.sign-in] Response: {}", response);
    return response;
  }
}
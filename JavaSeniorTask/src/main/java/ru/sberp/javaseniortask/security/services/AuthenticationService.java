package ru.sberp.javaseniortask.security.services;

import ru.sberp.javaseniortask.security.dto.JwtAuthenticationResponse;
import ru.sberp.javaseniortask.security.dto.SignInRequest;
import ru.sberp.javaseniortask.security.dto.SignUpRequest;

public interface AuthenticationService {

  JwtAuthenticationResponse signUp(SignUpRequest request);

  JwtAuthenticationResponse signIn(SignInRequest request);
}

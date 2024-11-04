package ru.sberp.javaseniortask.security.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sberp.javaseniortask.models.User;
import ru.sberp.javaseniortask.repositories.UserRepository;
import ru.sberp.javaseniortask.security.dto.JwtAuthenticationResponse;
import ru.sberp.javaseniortask.security.dto.SignInRequest;
import ru.sberp.javaseniortask.security.dto.SignUpRequest;
import ru.sberp.javaseniortask.security.services.AuthenticationService;
import ru.sberp.javaseniortask.security.services.JwtService;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  @Override
  public JwtAuthenticationResponse signUp(SignUpRequest request) {
    User user = User.builder()
        .name(request.getName())
        .password(passwordEncoder.encode(request.getPassword()))
        .build();

    userRepository.save(user);

    String jwt = jwtService.generateToken(user);

    return new JwtAuthenticationResponse(jwt);
  }

  @Override
  public JwtAuthenticationResponse signIn(SignInRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        request.getName(),
        request.getPassword()
    ));

    User user = userRepository
        .findUserByName(request.getName())
        .orElseThrow();

    String jwt = jwtService.generateToken(user);

    return new JwtAuthenticationResponse(jwt);
  }
}

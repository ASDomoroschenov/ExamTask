package ru.sberp.javaseniortask.controllers.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberp.javaseniortask.controllers.UserController;
import ru.sberp.javaseniortask.dto.request.user.UserCreateRequest;
import ru.sberp.javaseniortask.dto.request.user.UserSearchFilter;
import ru.sberp.javaseniortask.dto.request.user.UserUpdateRequest;
import ru.sberp.javaseniortask.dto.response.user.UserResponse;
import ru.sberp.javaseniortask.services.UserService;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserControllerImpl implements UserController {

  private final UserService service;

  @Override
  @PostMapping("/create")
  public ResponseEntity<UserResponse> createUser(UserCreateRequest request) {
    log.info("[user.create] Request: {}", request);
    UserResponse response = service.createUser(request);
    log.info("[user.create] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @PutMapping("/update")
  public ResponseEntity<UserResponse> updateUser(UserUpdateRequest request) {
    log.info("[user.update] Request: {}", request);
    UserResponse response = service.updateUser(request);
    log.info("[user.update] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @GetMapping("/get")
  public ResponseEntity<UserResponse> getUser(Long id) {
    log.info("[user.get] Param: {}", id);
    UserResponse response = service.getUser(id);
    log.info("[user.get] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @DeleteMapping("/delete")
  public ResponseEntity<UserResponse> deleteUser(Long id) {
    log.info("[user.delete] Param: {}", id);
    UserResponse response = service.deleteUser(id);
    log.info("[user.delete] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @GetMapping("/search")
  public ResponseEntity<List<UserResponse>> searchUser(
      int page,
      int size,
      UserSearchFilter filter) {
    log.info("[user.search] Request: {}", filter);
    List<UserResponse> response = service.searchUser(filter, PageRequest.of(page, size));
    log.info("[user.search] Response: {}", response);
    return ResponseEntity.ok(response);
  }
}

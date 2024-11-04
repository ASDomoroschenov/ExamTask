package ru.sberp.javaseniortask.controllers.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberp.javaseniortask.controllers.AccountController;
import ru.sberp.javaseniortask.dto.request.account.AccountCreateRequest;
import ru.sberp.javaseniortask.dto.request.account.AccountUpdateRequest;
import ru.sberp.javaseniortask.dto.response.account.AccountResponse;
import ru.sberp.javaseniortask.services.AccountService;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountControllerImpl implements AccountController {

  private final AccountService service;

  @Override
  @PostMapping("/create")
  public ResponseEntity<AccountResponse> createAccount(AccountCreateRequest request) {
    log.info("[account.create] Request: {}", request);
    AccountResponse response = service.createAccount(request);
    log.info("[account.create] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @PutMapping("/update")
  public ResponseEntity<AccountResponse> updateAccount(AccountUpdateRequest request) {
    log.info("[account.update] Request: {}", request);
    AccountResponse response = service.updateAccount(request);
    log.info("[account.update] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @GetMapping("/get")
  public ResponseEntity<AccountResponse> getAccount(Long id) {
    log.info("[account.get] Param: {}", id);
    AccountResponse response = service.getAccount(id);
    log.info("[account.get] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @DeleteMapping("/delete")
  public ResponseEntity<AccountResponse> deleteAccount(Long id) {
    log.info("[account.delete] Param: {}", id);
    AccountResponse response = service.deleteAccount(id);
    log.info("[account.delete] Response: {}", response);
    return ResponseEntity.ok(response);
  }
}

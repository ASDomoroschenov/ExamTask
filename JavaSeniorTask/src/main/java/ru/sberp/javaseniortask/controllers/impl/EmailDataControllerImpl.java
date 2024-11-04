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
import ru.sberp.javaseniortask.controllers.EmailDataController;
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.emaildata.EmailDataResponse;
import ru.sberp.javaseniortask.services.EmailDataService;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/email-data")
public class EmailDataControllerImpl implements EmailDataController {

  private final EmailDataService service;

  @Override
  @PostMapping("/create")
  public ResponseEntity<EmailDataResponse> createEmailData(EmailDataCreateRequest request) {
    log.info("[email-data.create] Request: {}", request);
    EmailDataResponse response = service.createEmailData(request);
    log.info("[email-data.create] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @PutMapping("/update")
  public ResponseEntity<EmailDataResponse> updateEmailData(EmailDataUpdateRequest request) {
    log.info("[email-data.update] Request: {}", request);
    EmailDataResponse response = service.updateEmailData(request);
    log.info("[email-data.update] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @GetMapping("/get")
  public ResponseEntity<EmailDataResponse> getEmailData(Long id) {
    log.info("[email-data.get] Param: {}", id);
    EmailDataResponse response = service.getEmailData(id);
    log.info("[email-data.get] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @DeleteMapping("/delete")
  public ResponseEntity<EmailDataResponse> deleteEmailData(Long id) {
    log.info("[email-data.delete] Param: {}", id);
    EmailDataResponse response = service.deleteEmailData(id);
    log.info("[email-data.delete] Response: {}", response);
    return ResponseEntity.ok(response);
  }
}

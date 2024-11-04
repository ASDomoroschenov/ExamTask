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
import ru.sberp.javaseniortask.controllers.PhoneDataController;
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.phonedata.PhoneDataResponse;
import ru.sberp.javaseniortask.services.PhoneDataService;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/phone-data")
public class PhoneDataControllerImpl implements PhoneDataController {

  private final PhoneDataService service;

  @Override
  @PostMapping("/create")
  public ResponseEntity<PhoneDataResponse> createPhoneData(PhoneDataCreateRequest request) {
    log.info("[phone-data.create] Request: {}", request);
    PhoneDataResponse response = service.createPhoneData(request);
    log.info("[phone-data.create] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @PutMapping("/update")
  public ResponseEntity<PhoneDataResponse> updatePhoneData(PhoneDataUpdateRequest request) {
    log.info("[phone-data.update] Request: {}", request);
    PhoneDataResponse response = service.updatePhoneData(request);
    log.info("[phone-data.update] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @GetMapping("/get")
  public ResponseEntity<PhoneDataResponse> getPhoneData(Long id) {
    log.info("[phone-data.get] Param: {}", id);
    PhoneDataResponse response = service.getPhoneData(id);
    log.info("[phone-data.get] Response: {}", response);
    return ResponseEntity.ok(response);
  }

  @Override
  @DeleteMapping("/delete")
  public ResponseEntity<PhoneDataResponse> deletePhoneData(Long id) {
    log.info("[phone-data.delete] Param: {}", id);
    PhoneDataResponse response = service.deletePhoneData(id);
    log.info("[phone-data.delete] Response: {}", response);
    return ResponseEntity.ok(response);
  }
}

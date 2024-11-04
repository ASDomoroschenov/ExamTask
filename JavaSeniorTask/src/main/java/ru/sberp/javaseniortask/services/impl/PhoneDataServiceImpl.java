package ru.sberp.javaseniortask.services.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.sberp.javaseniortask.dto.mapper.PhoneDataMapper;
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.phonedata.PhoneDataResponse;
import ru.sberp.javaseniortask.models.PhoneData;
import ru.sberp.javaseniortask.repositories.PhoneDataRepository;
import ru.sberp.javaseniortask.services.PhoneDataService;

@Service
@RequiredArgsConstructor
public class PhoneDataServiceImpl implements PhoneDataService {

  private final PhoneDataMapper mapper;
  private final PhoneDataRepository repository;

  @Override
  @CachePut(value = "phones", key = "#result.id")
  public PhoneDataResponse createPhoneData(PhoneDataCreateRequest request) {
    PhoneData model = mapper.requestToModel(request);
    PhoneData savedPhoneData = repository.saveAndFlush(model);
    return mapper.modelToResponse(savedPhoneData);
  }

  @Override
  @CachePut(value = "phones", key = "#request.id")
  public PhoneDataResponse updatePhoneData(PhoneDataUpdateRequest request) {
    PhoneData model = mapper.requestToModel(request);
    PhoneData savedPhoneData = repository.saveAndFlush(model);
    return mapper.modelToResponse(savedPhoneData);
  }

  @Override
  @Cacheable(value = "phones", key = "#id")
  public PhoneDataResponse getPhoneData(Long id) {
    return mapper.modelToResponse(repository.findById(id).orElseThrow());
  }

  @Override
  @CacheEvict(value = "phones", key = "#id")
  public PhoneDataResponse deletePhoneData(Long id) {
    PhoneData deletedPhoneData = repository.findById(id).orElseThrow();
    repository.delete(deletedPhoneData);
    return mapper.modelToResponse(deletedPhoneData);
  }
}

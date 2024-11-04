package ru.sberp.javaseniortask.services.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.sberp.javaseniortask.dto.mapper.EmailDataMapper;
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.emaildata.EmailDataResponse;
import ru.sberp.javaseniortask.models.EmailData;
import ru.sberp.javaseniortask.repositories.EmailDataRepository;
import ru.sberp.javaseniortask.services.EmailDataService;

@Service
@RequiredArgsConstructor
public class EmailDataServiceImpl implements EmailDataService {

  private final EmailDataMapper mapper;
  private final EmailDataRepository repository;

  @Override
  @CachePut(value = "emails", key = "#result.id")
  public EmailDataResponse createEmailData(EmailDataCreateRequest request) {
    EmailData model = mapper.requestToModel(request);
    EmailData savedEmailData = repository.saveAndFlush(model);
    return mapper.modelToResponse(savedEmailData);
  }

  @Override
  @CachePut(value = "emails", key = "#request.id")
  public EmailDataResponse updateEmailData(EmailDataUpdateRequest request) {
    EmailData model = mapper.requestToModel(request);
    EmailData savedEmailData = repository.saveAndFlush(model);
    return mapper.modelToResponse(savedEmailData);
  }

  @Override
  @Cacheable(value = "emails", key = "#id")
  public EmailDataResponse getEmailData(Long id) {
    return mapper.modelToResponse(repository.findById(id).orElseThrow());
  }

  @Override
  @CacheEvict(value = "emails", key = "#id")
  public EmailDataResponse deleteEmailData(Long id) {
    EmailData deletedEmailData = repository.findById(id).orElseThrow();
    repository.delete(deletedEmailData);
    return mapper.modelToResponse(deletedEmailData);
  }
}

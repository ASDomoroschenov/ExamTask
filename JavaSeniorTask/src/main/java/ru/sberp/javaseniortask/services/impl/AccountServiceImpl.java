package ru.sberp.javaseniortask.services.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.sberp.javaseniortask.dto.mapper.AccountMapper;
import ru.sberp.javaseniortask.dto.request.account.AccountCreateRequest;
import ru.sberp.javaseniortask.dto.request.account.AccountUpdateRequest;
import ru.sberp.javaseniortask.dto.response.account.AccountResponse;
import ru.sberp.javaseniortask.models.Account;
import ru.sberp.javaseniortask.repositories.AccountRepository;
import ru.sberp.javaseniortask.services.AccountService;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountMapper mapper;
  private final AccountRepository repository;
  
  @Override
  @CachePut(value = "accounts", key = "#result.id")
  public AccountResponse createAccount(AccountCreateRequest request) {
    Account model = mapper.requestToModel(request);
    Account savedAccount = repository.saveAndFlush(model);
    return mapper.modelToResponse(savedAccount);
  }

  @Override
  @CachePut(value = "accounts", key = "#request.id")
  public AccountResponse updateAccount(AccountUpdateRequest request) {
    Account model = mapper.requestToModel(request);
    Account savedAccount = repository.saveAndFlush(model);
    return mapper.modelToResponse(savedAccount);
  }

  @Override
  @Cacheable(value = "accounts", key = "#id")
  public AccountResponse getAccount(Long id) {
    return mapper.modelToResponse(repository.findById(id).orElseThrow());
  }

  @Override
  @CacheEvict(value = "accounts", key = "#id")
  public AccountResponse deleteAccount(Long id) {
    Account deletedAccount = repository.findById(id).orElseThrow();
    repository.delete(deletedAccount);
    return mapper.modelToResponse(deletedAccount);
  }
}

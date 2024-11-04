package ru.sberp.javaseniortask.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sberp.javaseniortask.dto.request.account.AccountCreateRequest;
import ru.sberp.javaseniortask.dto.request.account.AccountUpdateRequest;
import ru.sberp.javaseniortask.dto.response.account.AccountResponse;
import ru.sberp.javaseniortask.models.Account;
import ru.sberp.javaseniortask.repositories.UserRepository;

@Mapper(componentModel = ComponentModel.SPRING)
public abstract class AccountMapper {

  @Autowired
  protected UserRepository userRepository;

  @Mapping(target = "user", expression = "java(userRepository.findById(request.getUserId()).orElseThrow())")
  public abstract Account requestToModel(AccountCreateRequest request);

  @Mapping(target = "user", expression = "java(userRepository.findById(request.getUserId()).orElseThrow())")
  public abstract Account requestToModel(AccountUpdateRequest request);

  @Mapping(target = "userId", expression = "java(model.getUser().getId())")
  public abstract AccountResponse modelToResponse(Account model);
}

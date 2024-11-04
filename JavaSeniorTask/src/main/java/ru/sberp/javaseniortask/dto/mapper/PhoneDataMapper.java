package ru.sberp.javaseniortask.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.phonedata.PhoneDataResponse;
import ru.sberp.javaseniortask.models.PhoneData;
import ru.sberp.javaseniortask.repositories.UserRepository;

@Mapper(componentModel = ComponentModel.SPRING)
public abstract class PhoneDataMapper {

  @Autowired
  protected UserRepository userRepository;

  @Mapping(target = "user", expression = "java(userRepository.findById(request.getUserId()).orElseThrow())")
  public abstract PhoneData requestToModel(PhoneDataCreateRequest request);

  @Mapping(target = "user", expression = "java(userRepository.findById(request.getUserId()).orElseThrow())")
  public abstract PhoneData requestToModel(PhoneDataUpdateRequest request);

  @Mapping(target = "userId", expression = "java(model.getUser().getId())")
  public abstract PhoneDataResponse modelToResponse(PhoneData model);
}

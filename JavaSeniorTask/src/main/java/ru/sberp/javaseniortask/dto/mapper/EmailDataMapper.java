package ru.sberp.javaseniortask.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.emaildata.EmailDataResponse;
import ru.sberp.javaseniortask.models.EmailData;
import ru.sberp.javaseniortask.repositories.UserRepository;

@Mapper(componentModel = ComponentModel.SPRING)
public abstract class EmailDataMapper {

  @Autowired
  protected UserRepository userRepository;

  @Mapping(target = "user", expression = "java(userRepository.findById(request.getUserId()).orElseThrow())")
  public abstract EmailData requestToModel(EmailDataCreateRequest request);

  @Mapping(target = "user", expression = "java(userRepository.findById(request.getUserId()).orElseThrow())")
  public abstract EmailData requestToModel(EmailDataUpdateRequest request);

  @Mapping(target = "userId", expression = "java(model.getUser().getId())")
  public abstract EmailDataResponse modelToResponse(EmailData model);
}

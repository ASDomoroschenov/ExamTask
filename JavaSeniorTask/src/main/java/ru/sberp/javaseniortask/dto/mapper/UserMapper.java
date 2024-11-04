package ru.sberp.javaseniortask.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sberp.javaseniortask.dto.request.user.UserCreateRequest;
import ru.sberp.javaseniortask.dto.request.user.UserUpdateRequest;
import ru.sberp.javaseniortask.dto.response.user.UserResponse;
import ru.sberp.javaseniortask.models.User;

@Mapper(componentModel = ComponentModel.SPRING)
public abstract class UserMapper {

  public abstract User requestToModel(UserCreateRequest request);

  public abstract User requestToModel(UserUpdateRequest request);

  public abstract UserResponse modelToResponse(User model);
}

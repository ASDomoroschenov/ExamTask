package ru.sberp.javaseniortask.services;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.sberp.javaseniortask.dto.request.user.UserCreateRequest;
import ru.sberp.javaseniortask.dto.request.user.UserSearchFilter;
import ru.sberp.javaseniortask.dto.request.user.UserUpdateRequest;
import ru.sberp.javaseniortask.dto.response.user.UserResponse;
import ru.sberp.javaseniortask.models.User;

public interface UserService {

  UserResponse createUser(UserCreateRequest request);

  UserResponse updateUser(UserUpdateRequest request);

  UserResponse getUser(Long id);

  UserResponse deleteUser(Long id);

  List<UserResponse> searchUser(UserSearchFilter filter, Pageable page);

  User getByUsername(String username);

  UserDetailsService userDetailsService();
}

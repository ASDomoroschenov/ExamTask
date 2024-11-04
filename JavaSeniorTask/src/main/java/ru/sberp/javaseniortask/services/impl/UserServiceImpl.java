package ru.sberp.javaseniortask.services.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sberp.javaseniortask.dto.mapper.UserMapper;
import ru.sberp.javaseniortask.dto.request.user.UserCreateRequest;
import ru.sberp.javaseniortask.dto.request.user.UserSearchFilter;
import ru.sberp.javaseniortask.dto.request.user.UserUpdateRequest;
import ru.sberp.javaseniortask.dto.response.user.UserResponse;
import ru.sberp.javaseniortask.models.User;
import ru.sberp.javaseniortask.repositories.UserRepository;
import ru.sberp.javaseniortask.services.UserService;
import ru.sberp.javaseniortask.utils.UserSpecifications;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper mapper;
  private final UserRepository repository;

  @Override
  @CachePut(value = "users", key = "#result.id")
  public UserResponse createUser(UserCreateRequest request) {
    request.setPassword(request.getPassword());
    User model = mapper.requestToModel(request);
    User savedUser = repository.saveAndFlush(model);
    return mapper.modelToResponse(savedUser);
  }

  @Override
  @CachePut(value = "users", key = "#request.id")
  public UserResponse updateUser(UserUpdateRequest request) {
    request.setPassword(request.getPassword());
    User model = mapper.requestToModel(request);
    User savedUser = repository.saveAndFlush(model);
    return mapper.modelToResponse(savedUser);
  }

  @Override
  @Cacheable(value = "users", key = "#id")
  public UserResponse getUser(Long id) {
    return mapper.modelToResponse(repository.findById(id).orElseThrow());
  }

  @Override
  @CacheEvict(value = "users", key = "#id")
  public UserResponse deleteUser(Long id) {
    User deletedUser = repository.findById(id).orElseThrow();
    repository.delete(deletedUser);
    return mapper.modelToResponse(deletedUser);
  }

  @Override
  public List<UserResponse> searchUser(UserSearchFilter filter, Pageable page) {
    return repository
        .findAll(UserSpecifications.withFilters(filter), page)
        .stream()
        .map(mapper::modelToResponse)
        .toList();
  }

  @Override
  public User getByUsername(String username) {
    return repository.findUserByName(username).orElseThrow();
  }

  @Override
  public UserDetailsService userDetailsService() {
    return this::getByUsername;
  }
}

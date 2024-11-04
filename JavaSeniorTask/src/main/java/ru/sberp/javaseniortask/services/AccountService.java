package ru.sberp.javaseniortask.services;

import java.util.List;
import ru.sberp.javaseniortask.dto.request.account.AccountCreateRequest;
import ru.sberp.javaseniortask.dto.request.account.AccountUpdateRequest;
import ru.sberp.javaseniortask.dto.response.account.AccountResponse;

public interface AccountService {

  AccountResponse createAccount(AccountCreateRequest request);

  AccountResponse updateAccount(AccountUpdateRequest request);

  AccountResponse getAccount(Long id);

  AccountResponse deleteAccount(Long id);
}

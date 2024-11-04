package ru.sberp.javaseniortask.services;

import java.util.List;
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.emaildata.EmailDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.emaildata.EmailDataResponse;

public interface EmailDataService {

  EmailDataResponse createEmailData(EmailDataCreateRequest request);

  EmailDataResponse updateEmailData(EmailDataUpdateRequest request);

  EmailDataResponse getEmailData(Long id);

  EmailDataResponse deleteEmailData(Long id);
}

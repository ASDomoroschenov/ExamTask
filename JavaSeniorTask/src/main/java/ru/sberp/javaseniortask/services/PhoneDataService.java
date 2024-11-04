package ru.sberp.javaseniortask.services;

import java.util.List;
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataCreateRequest;
import ru.sberp.javaseniortask.dto.request.phonedata.PhoneDataUpdateRequest;
import ru.sberp.javaseniortask.dto.response.phonedata.PhoneDataResponse;

public interface PhoneDataService {

  PhoneDataResponse createPhoneData(PhoneDataCreateRequest request);

  PhoneDataResponse updatePhoneData(PhoneDataUpdateRequest request);

  PhoneDataResponse getPhoneData(Long id);

  PhoneDataResponse deletePhoneData(Long id);
}

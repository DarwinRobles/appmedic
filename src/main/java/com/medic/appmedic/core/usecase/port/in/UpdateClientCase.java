package com.medic.appmedic.core.usecase.port.in;

import java.util.UUID;

import com.medic.appmedic.core.usecase.dto.request.CreateClientRequest;
import com.medic.appmedic.core.usecase.dto.response.ClientResponse;

public interface UpdateClientCase {

    ClientResponse updateClient(UUID id, CreateClientRequest request);

}
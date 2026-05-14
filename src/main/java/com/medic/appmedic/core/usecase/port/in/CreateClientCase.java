package com.medic.appmedic.core.usecase.port.in;

import com.medic.appmedic.core.usecase.dto.request.CreateClientRequest;
import com.medic.appmedic.core.usecase.dto.response.ClientResponse;

public interface CreateClientCase {
    ClientResponse createClient(CreateClientRequest request);
}

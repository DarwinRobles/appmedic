package com.medic.appmedic.core.usecase.port.in;

import java.util.List;

import com.medic.appmedic.core.usecase.dto.response.ClientResponse;

public interface GetListClientCase {
    List<ClientResponse> getListClient();
}

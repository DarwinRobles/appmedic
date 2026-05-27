package com.medic.appmedic.core.usecase.port.in;

import java.util.UUID;

import com.medic.appmedic.core.usecase.dto.response.UserResponse;

public interface GetUserCase {
    UserResponse getUserById(UUID id);

}

package com.medic.appmedic.core.usecase.port.in;


import com.medic.appmedic.core.usecase.dto.request.RegisterUserRequest;
import com.medic.appmedic.core.usecase.dto.response.UserResponse;

public interface RegisterUserCase {
    UserResponse registerUser(RegisterUserRequest request);
}

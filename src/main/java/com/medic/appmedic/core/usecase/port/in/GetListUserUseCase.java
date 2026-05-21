package com.medic.appmedic.core.usecase.port.in;

import com.medic.appmedic.core.usecase.dto.response.UserResponse;
import java.util.List;

public interface GetListUserUseCase {
    List<UserResponse> getListUser();
}
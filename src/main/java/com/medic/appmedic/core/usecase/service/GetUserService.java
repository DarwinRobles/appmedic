package com.medic.appmedic.core.usecase.service;

import java.util.Optional;
import java.util.UUID;

import com.medic.appmedic.core.entity.User;
import com.medic.appmedic.core.usecase.dto.response.UserResponse;
import com.medic.appmedic.core.usecase.port.in.GetUserCase;
import com.medic.appmedic.core.usecase.port.out.UserRepositoryPort;

public class GetUserService implements GetUserCase {
    private final UserRepositoryPort userRepositoryPort;

    public GetUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserResponse getUserById(UUID id) {
        Optional<User> user = userRepositoryPort.findById(id);

        return new UserResponse(

            user.get().getId(),
            user.get().getName(),
            user.get().getLastName(),
            user.get().getFirstName(),
            user.get().getEmail(),
            user.get().getPhone(),
            user.get().getCreatedAt(),
            user.get().getUpdatedAt(),
            user.get().getRole()
        );
    }
}

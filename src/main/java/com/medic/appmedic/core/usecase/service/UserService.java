package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.entity.User;
import com.medic.appmedic.core.usecase.dto.request.RegisterUserRequest;
import com.medic.appmedic.core.usecase.dto.response.UserResponse;
import com.medic.appmedic.core.usecase.port.in.DeleteUserCase;
import com.medic.appmedic.core.usecase.port.in.RegisterUserCase;
import com.medic.appmedic.core.usecase.port.out.UserRepositoryPort;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService implements RegisterUserCase, DeleteUserCase {
    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserResponse registerUser(RegisterUserRequest request) {
        User user = new User();

        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setRole("USER");

        User savedUser = userRepositoryPort.save(user);

        return new UserResponse (
               savedUser.getId(),
               savedUser.getName(),
               savedUser.getLastName(),
               savedUser.getFirstName(),
               savedUser.getEmail(),
               savedUser.getPhone(),
               savedUser.getCreatedAt(),
               savedUser.getUpdatedAt(),
               savedUser.getRole()
        );

    }


    @Override
    public void delete(UUID id) {
        userRepositoryPort.deleteById(id);
    }
}

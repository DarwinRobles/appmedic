package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.entity.User;
import com.medic.appmedic.core.usecase.dto.request.RegisterUserRequest;
import com.medic.appmedic.core.usecase.dto.response.UserResponse;
import com.medic.appmedic.core.usecase.port.in.RegisterUserCase;
import com.medic.appmedic.core.usecase.port.in.GetListUserUseCase;
import com.medic.appmedic.core.usecase.port.out.UserRepositoryPort;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements RegisterUserCase, GetListUserUseCase {
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
    public List<UserResponse> getListUser() {
        List<User> users = userRepositoryPort.findAll();

        return users.stream().map(user -> new UserResponse(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getFirstName(),
                user.getEmail(),
                user.getPhone(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getRole()
        )).collect(Collectors.toList());
    }
}
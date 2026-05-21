package com.medic.appmedic.infrastructure.persistence.controller;

import com.medic.appmedic.core.usecase.dto.request.RegisterUserRequest;
import com.medic.appmedic.core.usecase.dto.response.UserResponse;
import com.medic.appmedic.core.usecase.port.in.RegisterUserCase;
import com.medic.appmedic.core.usecase.port.in.GetListUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final RegisterUserCase registerUserCase;
    private final GetListUserUseCase getListUserUseCase;

    public UserController(RegisterUserCase registerUserCase, GetListUserUseCase getListUserUseCase) {
        this.registerUserCase = registerUserCase;
        this.getListUserUseCase = getListUserUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterUserRequest request) {
        return ResponseEntity.ok(registerUserCase.registerUser(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getListUser() {
        return ResponseEntity.ok(getListUserUseCase.getListUser());
    }
}
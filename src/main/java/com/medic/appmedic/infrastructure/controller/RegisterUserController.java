package com.medic.appmedic.infrastructure.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medic.appmedic.core.usecase.dto.request.RegisterUserRequest;
import com.medic.appmedic.core.usecase.dto.response.UserResponse;
import com.medic.appmedic.core.usecase.port.in.RegisterUserCase;


@RestController
@RequestMapping("/api/users")
public class RegisterUserController {
    private final RegisterUserCase registerUserCase;

    public RegisterUserController(RegisterUserCase registerUserCase){
        this.registerUserCase = registerUserCase;
    }

    @PostMapping("register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest request){
        UserResponse user = registerUserCase.registerUser(request);
        return ResponseEntity.ok(user);
    }

}

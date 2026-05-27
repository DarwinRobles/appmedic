package com.medic.appmedic.infrastructure.controller;

import com.medic.appmedic.core.usecase.dto.request.RegisterUserRequest;
import com.medic.appmedic.core.usecase.dto.response.UserResponse;
import com.medic.appmedic.core.usecase.port.in.RegisterUserCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRegisterController {
    private final RegisterUserCase registerUserCase;

    public UserRegisterController(RegisterUserCase registerUserCase){
        this.registerUserCase = registerUserCase;
    }

    @PostMapping("register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest request){
        UserResponse user = registerUserCase.registerUser(request);
        return ResponseEntity.ok(user);
    }

}

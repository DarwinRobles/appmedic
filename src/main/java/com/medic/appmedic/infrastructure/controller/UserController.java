package com.medic.appmedic.infrastructure.controller;

import com.medic.appmedic.core.usecase.dto.request.RegisterUserRequest;
import com.medic.appmedic.core.usecase.dto.response.UserResponse;
import com.medic.appmedic.core.usecase.port.in.DeleteUserCase;
import com.medic.appmedic.core.usecase.port.in.RegisterUserCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public class UserController {
    private final RegisterUserCase registerUserCase;
    private final DeleteUserCase deleteUserCase;

    public UserController(RegisterUserCase registerUserCase, DeleteUserCase deleteUserCase){
        this.registerUserCase = registerUserCase;
        this.deleteUserCase = deleteUserCase;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterUserRequest request){
        UserResponse response = registerUserCase.registerUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        deleteUserCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

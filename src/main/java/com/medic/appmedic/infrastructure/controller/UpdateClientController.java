package com.medic.appmedic.infrastructure.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medic.appmedic.core.usecase.dto.request.CreateClientRequest;
import com.medic.appmedic.core.usecase.dto.response.ClientResponse;
import com.medic.appmedic.core.usecase.port.in.UpdateClientCase;

@RestController
@RequestMapping("/clients")
public class UpdateClientController {
    private final UpdateClientCase updateClientCase;
    
    public UpdateClientController(UpdateClientCase updateClientCase){
        this.updateClientCase = updateClientCase;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient (@PathVariable UUID id, @RequestBody CreateClientRequest request){
        ClientResponse response = updateClientCase.updateClient(id, request);
        return ResponseEntity.ok(response);
    }
}

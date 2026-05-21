package com.medic.appmedic.infrastructure.controller;

import com.medic.appmedic.core.usecase.dto.request.CreateClientRequest;
import com.medic.appmedic.core.usecase.dto.response.ClientResponse;
import com.medic.appmedic.core.usecase.port.in.CreateClientCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final CreateClientCase createClientCase;

    public ClientController(CreateClientCase createClientCase){
        this.createClientCase = createClientCase;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody CreateClientRequest request) {
        ClientResponse response = createClientCase.createClient(request);
        return  ResponseEntity.ok(response);
    }
}

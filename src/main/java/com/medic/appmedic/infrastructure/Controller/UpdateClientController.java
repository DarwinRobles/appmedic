package com.ecommerce_isil.webapp.infrastructure.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.request.CreateClientRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.ClientResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.UpdateClientCase;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMappingMapping; 
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class UpdateClientController {
    private final UpdateClientCase updateClientCase;

    public UpdateClientController(UpdateClienteCase updateClientCase){
        this.updateClientCase = updateClientCase;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable UUID id, @RequestBody CreateClientRequest request){

        ClientResponse response = updateClientCase.updateClient(id, request);
        return ResponseEntity.ok(response);
    }
}
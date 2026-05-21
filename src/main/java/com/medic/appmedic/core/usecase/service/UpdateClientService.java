package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.entity.Client;
import com.medic.appmedic.core.usecase.dto.request.CreateClientRequest;
import com.medic.appmedic.core.usecase.dto.response.ClientResponse;
import com.medic.appmedic.core.usecase.port.in.UpdateClientCase;
import com.medic.appmedic.core.usecase.port.out.ClientRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateClientService implements UpdateClientCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public UpdateClientService(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public ClientResponse updateClient(UUID id, CreateClientRequest request) {

        Client existingClient = clientRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        if(request.getFullName() != null){
            existingClient.setFullName(request.getFullName());
        }

        if(request.getEmail() != null){
            existingClient.setEmail(request.getEmail());
        }

        if(request.getPhone() != null){
            existingClient.setPhone(request.getPhone());
        }

        if(request.getDocumentId() != null){
            existingClient.setDocumentId(request.getDocumentId());
        }

        if(request.getBirthDate() != null){
            existingClient.setBirthDate(request.getBirthDate());
        }

        if(request.getAddress() != null){
            existingClient.setAddress(request.getAddress());
        }

        if(request.getNotes() != null){
            existingClient.setNotes(request.getNotes());
        }

        Client clientUpdate = clientRepositoryPort.updateClient(existingClient);

        return new ClientResponse(
                clientUpdate.getId(),
                clientUpdate.getFullName(),
                clientUpdate.getEmail(),
                clientUpdate.getPhone(),
                clientUpdate.getDocumentId(),
                clientUpdate.getBirthDate(),
                clientUpdate.getAddress(),
                clientUpdate.getNotes(),
                clientUpdate.getCreatedAt(),
                clientUpdate.getUpdatedAt()
            );
    }
}
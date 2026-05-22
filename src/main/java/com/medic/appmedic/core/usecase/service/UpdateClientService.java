package com.medic.appmedic.core.usecase.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.medic.appmedic.core.entity.Client;
import com.medic.appmedic.core.usecase.dto.request.CreateClientRequest;
import com.medic.appmedic.core.usecase.dto.response.ClientResponse;
import com.medic.appmedic.core.usecase.port.in.UpdateClientCase;
import com.medic.appmedic.core.usecase.port.out.ClientRepositoryPort;

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
        if (existingClient.getFullName() != null) {
            existingClient.setFullName(request.getFullName());
        }
        if (existingClient.getEmail() != null) {
            existingClient.setEmail(request.getEmail());
        }
        if (existingClient.getPhone() != null) {
            existingClient.setPhone(request.getPhone());
        }
        if (existingClient.getDocumentId() != null) {
            existingClient.setDocumentId(request.getDocumentId());
        }
        if (existingClient.getBirthDate() != null) {
            existingClient.setBirthDate(request.getBirthDate());
        }
        if (existingClient.getAddress() != null) {
            existingClient.setAddress(request.getAddress());
        }
        if (existingClient.getNotes() != null) {
            existingClient.setNotes(request.getNotes());
        }
        if (existingClient.getCreatedAt() != null) {
            existingClient.setCreatedAt(request.getCreatedAt());
        }
        if (existingClient.getUpdatedAt() != null) {
            existingClient.setUpdatedAt(request.getUpdatedAt());
        }

        Client clientUpdated = clientRepositoryPort.updateClient(existingClient);

        return new ClientResponse(
                clientUpdated.getId(),
                clientUpdated.getFullName(),
                clientUpdated.getEmail(),
                clientUpdated.getPhone(),
                clientUpdated.getDocumentId(),
                clientUpdated.getBirthDate(),
                clientUpdated.getAddress(),
                clientUpdated.getNotes(),
                clientUpdated.getCreatedAt(),
                clientUpdated.getUpdatedAt()
            );
    }
}
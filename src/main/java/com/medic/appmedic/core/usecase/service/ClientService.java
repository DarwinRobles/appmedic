package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.entity.Client;
import com.medic.appmedic.core.usecase.dto.request.CreateClientRequest;
import com.medic.appmedic.core.usecase.dto.response.ClientResponse;
import com.medic.appmedic.core.usecase.port.in.CreateClientCase;
import com.medic.appmedic.core.usecase.port.out.ClientRepositoryPort;

import org.springframework.stereotype.Service;

import java.time.LocalDate;


public class ClientService implements CreateClientCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public ClientService(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public ClientResponse createClient(CreateClientRequest request) {
        Client client = new Client();
        client.setFullName(request.getFullName());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        client.setDocumentId(request.getDocumentId());
        client.setBirthDate(request.getBirthDate());
        client.setAddress(request.getAddress());
        client.setNotes(request.getNotes());
        LocalDate now = LocalDate.now();
        client.setCreatedAt(now);
        client.setUpdatedAt(now);

        Client saved = clientRepositoryPort.save(client);

        return new ClientResponse(
                saved.getId(),
                saved.getFullName(),
                saved.getEmail(),
                saved.getPhone(),
                saved.getDocumentId(),
                saved.getBirthDate(),
                saved.getAddress(),
                saved.getNotes(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }
}

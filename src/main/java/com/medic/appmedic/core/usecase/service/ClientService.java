package com.medic.appmedic.core.usecase.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.medic.appmedic.core.entity.Client;
import com.medic.appmedic.core.usecase.dto.request.CreateClientRequest;
import com.medic.appmedic.core.usecase.dto.response.ClientResponse;
import com.medic.appmedic.core.usecase.port.in.CreateClientCase;
import com.medic.appmedic.core.usecase.port.in.DeleteClientCase; 
import com.medic.appmedic.core.usecase.port.in.GetListClientCase;
import com.medic.appmedic.core.usecase.port.out.ClientRepositoryPort;

@Service
public class ClientService implements CreateClientCase, GetListClientCase, DeleteClientCase {
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

    @Override
    public void deleteClient(UUID id) {
        clientRepositoryPort.deleteById(id);
    }

    @Override
    public List<ClientResponse> getListClient() {
         List<Client> clients = clientRepositoryPort.findAll();
        

        return clients.stream()
                .map(saved -> new ClientResponse(
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
                ))
                .collect(Collectors.toList());

    }
}

package com.medic.appmedic.infrastructure.persistence.adapter;

import com.medic.appmedic.core.entity.Client;
import com.medic.appmedic.core.usecase.port.out.ClientRepositoryPort;
import com.medic.appmedic.infrastructure.persistence.entity.ClientJpaEntity;
import com.medic.appmedic.infrastructure.persistence.jpa.ClientRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {
    private final ClientRepository clientRepository;

    public ClientRepositoryAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        ClientJpaEntity entity = toEntity(client);
        ClientJpaEntity saved = clientRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id).map(this::toDomain);
    }

    private ClientJpaEntity toEntity(Client client) {
        ClientJpaEntity entity = new ClientJpaEntity();
        entity.setId(client.getId());
        entity.setFullName(client.getFullName());
        entity.setEmail(client.getEmail());
        entity.setPhone(client.getPhone());
        entity.setDocumentId(client.getDocumentId());
        entity.setBirthDate(client.getBirthDate());
        entity.setAddress(client.getAddress());
        entity.setNotes(client.getNotes());
        entity.setCreatedAt(client.getCreatedAt());
        entity.setUpdatedAt(client.getUpdatedAt());
        return entity;
    }

    private Client toDomain(ClientJpaEntity entity) {
        Client client = new Client();
        client.setId(entity.getId());
        client.setFullName(entity.getFullName());
        client.setEmail(entity.getEmail());
        client.setPhone(entity.getPhone());
        client.setDocumentId(entity.getDocumentId());
        client.setBirthDate(entity.getBirthDate());
        client.setAddress(entity.getAddress());
        client.setNotes(entity.getNotes());
        client.setCreatedAt(entity.getCreatedAt());
        client.setUpdatedAt(entity.getUpdatedAt());
        return client;
    }
}

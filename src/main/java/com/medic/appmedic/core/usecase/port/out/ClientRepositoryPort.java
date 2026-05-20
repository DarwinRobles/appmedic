package com.medic.appmedic.core.usecase.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.medic.appmedic.core.entity.Client;

public interface ClientRepositoryPort {
    Client save(Client client);
    List<Client> findAll(); 
    void deleteById(UUID id);
    Optional<Client> findById(UUID id);
}

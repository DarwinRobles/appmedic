package com.medic.appmedic.core.usecase.port.out;

import com.medic.appmedic.core.entity.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryPort {
    Client save(Client client);

    Optional<Client> findById(UUID id);
}

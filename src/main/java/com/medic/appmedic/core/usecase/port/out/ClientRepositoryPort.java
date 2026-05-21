package com.medic.appmedic.core.usecase.port.out;

import com.medic.appmedic.core.entity.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface ClientRepositoryPort {
    Client save(Client client);

    Optional<Client> findById(UUID id);
}

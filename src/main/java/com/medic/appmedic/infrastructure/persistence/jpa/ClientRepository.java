package com.medic.appmedic.infrastructure.persistence.jpa;

import com.medic.appmedic.infrastructure.persistence.entity.ClientJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientJpaEntity, UUID> {
}

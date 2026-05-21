package com.medic.appmedic.infrastructure.persistence.jpa;

import com.medic.appmedic.infrastructure.persistence.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserJpaEntity, UUID> {
}

package com.medic.appmedic.infrastructure.persistence.jpa;

import com.medic.appmedic.infrastructure.persistence.entity.MedicalServiceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicalServiceRepository extends JpaRepository<MedicalServiceJpaEntity, UUID> {
}

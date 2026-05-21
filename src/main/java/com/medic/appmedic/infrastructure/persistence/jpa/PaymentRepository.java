package com.medic.appmedic.infrastructure.persistence.jpa;

import com.medic.appmedic.infrastructure.persistence.entity.PaymentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentJpaEntity, UUID> {
}

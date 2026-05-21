package com.medic.appmedic.infrastructure.persistence.jpa;

import com.medic.appmedic.infrastructure.persistence.entity.BookingJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<BookingJpaEntity, UUID> {
}

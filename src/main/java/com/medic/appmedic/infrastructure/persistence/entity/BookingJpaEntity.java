package com.medic.appmedic.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class BookingJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID clientId;
    private UUID serviceId;
    private UUID userId;
    private LocalDateTime scheduledAt;
    private String status;
    private String reason;
    private String notes;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public BookingJpaEntity() {}
}

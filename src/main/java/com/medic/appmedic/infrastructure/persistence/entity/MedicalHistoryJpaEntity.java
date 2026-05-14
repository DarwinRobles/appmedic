package com.medic.appmedic.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "medical_histories")
public class MedicalHistoryJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID clientId;
    private UUID bookingId;
    private UUID userId;
    private String diagnosis;
    private String treatment;
    private String observations;
    private Instant recordedAt;

    public MedicalHistoryJpaEntity() {}
}

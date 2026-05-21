package com.medic.appmedic.core.entity;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalHistory {
    private UUID id;
    private UUID clientId;
    private UUID bookingId;
    private UUID userId;
    private String diagnosis;
    private String treatment;
    private String observations;
    private Instant recordedAt;

    public MedicalHistory() {}
}

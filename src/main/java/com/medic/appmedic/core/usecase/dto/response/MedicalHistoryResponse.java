package com.medic.appmedic.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class MedicalHistoryResponse {
    private UUID id;
    private UUID clientId;
    private UUID bookingId;
    private UUID userId;
    private String diagnosis;
    private String treatment;
    private String observations;
    private Instant recordedAt;

    public MedicalHistoryResponse(
            UUID id,
            UUID clientId,
            UUID bookingId,
            UUID userId,
            String diagnosis,
            String treatment,
            String observations,
            Instant recordedAt
    ) {
        this.id = id;
        this.clientId = clientId;
        this.bookingId = bookingId;
        this.userId = userId;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.observations = observations;
        this.recordedAt = recordedAt;
    }
}

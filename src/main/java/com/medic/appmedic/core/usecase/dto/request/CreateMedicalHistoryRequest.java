package com.medic.appmedic.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateMedicalHistoryRequest {
    private UUID clientId;
    private UUID bookingId;
    private UUID userId;
    private String diagnosis;
    private String treatment;
    private String observations;

    public CreateMedicalHistoryRequest(
            UUID clientId,
            UUID bookingId,
            UUID userId,
            String diagnosis,
            String treatment,
            String observations
    ) {
        this.clientId = clientId;
        this.bookingId = bookingId;
        this.userId = userId;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.observations = observations;
    }
}

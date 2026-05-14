package com.medic.appmedic.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CreateBookingRequest {
    private UUID clientId;
    private UUID serviceId;
    private UUID userId;
    private LocalDateTime scheduledAt;
    private String status;
    private String reason;
    private String notes;

    public CreateBookingRequest(
            UUID clientId,
            UUID serviceId,
            UUID userId,
            LocalDateTime scheduledAt,
            String status,
            String reason,
            String notes
    ) {
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.userId = userId;
        this.scheduledAt = scheduledAt;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
    }
}

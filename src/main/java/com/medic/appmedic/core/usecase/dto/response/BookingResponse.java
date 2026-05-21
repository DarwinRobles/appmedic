package com.medic.appmedic.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class BookingResponse {
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

    public BookingResponse(
            UUID id,
            UUID clientId,
            UUID serviceId,
            UUID userId,
            LocalDateTime scheduledAt,
            String status,
            String reason,
            String notes,
            LocalDate createdAt,
            LocalDate updatedAt
    ) {
        this.id = id;
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.userId = userId;
        this.scheduledAt = scheduledAt;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

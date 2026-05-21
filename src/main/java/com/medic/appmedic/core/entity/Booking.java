package com.medic.appmedic.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Booking {
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

    public Booking() {}
}

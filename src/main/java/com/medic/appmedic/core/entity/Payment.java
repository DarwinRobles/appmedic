package com.medic.appmedic.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Payment {
    private UUID id;
    private UUID bookingId;
    private BigDecimal amount;
    private String method;
    private String status;
    private String reference;
    private Instant paidAt;
    private LocalDate createdAt;

    public Payment() {}
}

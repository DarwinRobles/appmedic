package com.medic.appmedic.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class PaymentResponse {
    private UUID id;
    private UUID bookingId;
    private BigDecimal amount;
    private String method;
    private String status;
    private String reference;
    private Instant paidAt;
    private LocalDate createdAt;

    public PaymentResponse(
            UUID id,
            UUID bookingId,
            BigDecimal amount,
            String method,
            String status,
            String reference,
            Instant paidAt,
            LocalDate createdAt
    ) {
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.reference = reference;
        this.paidAt = paidAt;
        this.createdAt = createdAt;
    }
}

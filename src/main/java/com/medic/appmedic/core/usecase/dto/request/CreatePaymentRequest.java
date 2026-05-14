package com.medic.appmedic.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreatePaymentRequest {
    private UUID bookingId;
    private BigDecimal amount;
    private String method;
    private String status;
    private String reference;

    public CreatePaymentRequest(
            UUID bookingId,
            BigDecimal amount,
            String method,
            String status,
            String reference
    ) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.reference = reference;
    }
}

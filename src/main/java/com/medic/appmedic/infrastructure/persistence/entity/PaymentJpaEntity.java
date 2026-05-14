package com.medic.appmedic.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class PaymentJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID bookingId;
    private BigDecimal amount;
    private String method;
    private String status;
    private String reference;
    private Instant paidAt;
    private LocalDate createdAt;

    public PaymentJpaEntity() {}
}

package com.medic.appmedic.infrastructure.persistence.adapter;

import com.medic.appmedic.core.entity.Payment;
import com.medic.appmedic.core.usecase.port.out.PaymentRepositoryPort;
import com.medic.appmedic.infrastructure.persistence.entity.PaymentJpaEntity;
import com.medic.appmedic.infrastructure.persistence.jpa.PaymentRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PaymentRepositoryAdapter implements PaymentRepositoryPort {
    private final PaymentRepository paymentRepository;

    public PaymentRepositoryAdapter(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment save(Payment payment) {
        PaymentJpaEntity entity = toEntity(payment);
        PaymentJpaEntity saved = paymentRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return paymentRepository.findById(id).map(this::toDomain);
    }

    private PaymentJpaEntity toEntity(Payment payment) {
        PaymentJpaEntity entity = new PaymentJpaEntity();
        entity.setId(payment.getId());
        entity.setBookingId(payment.getBookingId());
        entity.setAmount(payment.getAmount());
        entity.setMethod(payment.getMethod());
        entity.setStatus(payment.getStatus());
        entity.setReference(payment.getReference());
        entity.setPaidAt(payment.getPaidAt());
        entity.setCreatedAt(payment.getCreatedAt());
        return entity;
    }

    private Payment toDomain(PaymentJpaEntity entity) {
        Payment payment = new Payment();
        payment.setId(entity.getId());
        payment.setBookingId(entity.getBookingId());
        payment.setAmount(entity.getAmount());
        payment.setMethod(entity.getMethod());
        payment.setStatus(entity.getStatus());
        payment.setReference(entity.getReference());
        payment.setPaidAt(entity.getPaidAt());
        payment.setCreatedAt(entity.getCreatedAt());
        return payment;
    }
}

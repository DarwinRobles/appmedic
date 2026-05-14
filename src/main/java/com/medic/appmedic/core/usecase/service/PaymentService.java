package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.entity.Payment;
import com.medic.appmedic.core.usecase.dto.request.CreatePaymentRequest;
import com.medic.appmedic.core.usecase.dto.response.PaymentResponse;
import com.medic.appmedic.core.usecase.port.in.CreatePaymentCase;
import com.medic.appmedic.core.usecase.port.out.PaymentRepositoryPort;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;


public class PaymentService implements CreatePaymentCase {
    private final PaymentRepositoryPort paymentRepositoryPort;

    public PaymentService(PaymentRepositoryPort paymentRepositoryPort) {
        this.paymentRepositoryPort = paymentRepositoryPort;
    }

    @Override
    public PaymentResponse createPayment(CreatePaymentRequest request) {
        Payment payment = new Payment();
        payment.setBookingId(request.getBookingId());
        payment.setAmount(request.getAmount());
        payment.setMethod(request.getMethod());
        payment.setStatus(request.getStatus());
        payment.setReference(request.getReference());
        payment.setPaidAt(Instant.now());
        payment.setCreatedAt(LocalDate.now());

        Payment saved = paymentRepositoryPort.save(payment);

        return new PaymentResponse(
                saved.getId(),
                saved.getBookingId(),
                saved.getAmount(),
                saved.getMethod(),
                saved.getStatus(),
                saved.getReference(),
                saved.getPaidAt(),
                saved.getCreatedAt()
        );
    }
}

package com.medic.appmedic.core.usecase.port.out;

import com.medic.appmedic.core.entity.Payment;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepositoryPort {
    Payment save(Payment payment);

    Optional<Payment> findById(UUID id);
}

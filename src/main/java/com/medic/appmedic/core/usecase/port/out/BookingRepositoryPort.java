package com.medic.appmedic.core.usecase.port.out;

import com.medic.appmedic.core.entity.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookingRepositoryPort {
    List<Booking> findAllBooking();

    Booking save(Booking booking);

    Optional<Booking> findById(UUID id);
}

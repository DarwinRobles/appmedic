package com.medic.appmedic.core.usecase.service;

import java.time.LocalDate;
import java.util.UUID;

import com.medic.appmedic.core.entity.Booking;
import com.medic.appmedic.core.usecase.dto.request.CreateBookingRequest;
import com.medic.appmedic.core.usecase.dto.response.BookingResponse;
import com.medic.appmedic.core.usecase.port.in.CancelBookingCase;
import com.medic.appmedic.core.usecase.port.in.CreateBookingCase;
import com.medic.appmedic.core.usecase.port.out.BookingRepositoryPort;

public class BookingService implements CreateBookingCase, CancelBookingCase {
    private final BookingRepositoryPort bookingRepositoryPort;

    public BookingService(BookingRepositoryPort bookingRepositoryPort) {
        this.bookingRepositoryPort = bookingRepositoryPort;
    }

    @Override
    public BookingResponse createBooking(CreateBookingRequest request) {
        Booking booking = new Booking();
        booking.setClientId(request.getClientId());
        booking.setServiceId(request.getServiceId());
        booking.setUserId(request.getUserId());
        booking.setScheduledAt(request.getScheduledAt());
        booking.setStatus(request.getStatus());
        booking.setReason(request.getReason());
        booking.setNotes(request.getNotes());
        LocalDate now = LocalDate.now();
        booking.setCreatedAt(now);
        booking.setUpdatedAt(now);

        Booking saved = bookingRepositoryPort.save(booking);

        return new BookingResponse(
                saved.getId(),
                saved.getClientId(),
                saved.getServiceId(),
                saved.getUserId(),
                saved.getScheduledAt(),
                saved.getStatus(),
                saved.getReason(),
                saved.getNotes(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }

    @Override
    public BookingResponse cancelBooking(UUID id) {
        Booking booking = bookingRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus("CANCELLED");
        booking.setUpdatedAt(LocalDate.now());

        Booking updated = bookingRepositoryPort.save(booking);

        return new BookingResponse(
                updated.getId(),
                updated.getClientId(),
                updated.getServiceId(),
                updated.getUserId(),
                updated.getScheduledAt(),
                updated.getStatus(),
                updated.getReason(),
                updated.getNotes(),
                updated.getCreatedAt(),
                updated.getUpdatedAt()
        );

    }
}

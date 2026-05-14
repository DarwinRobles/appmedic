package com.medic.appmedic.infrastructure.persistence.adapter;

import com.medic.appmedic.core.entity.Booking;
import com.medic.appmedic.core.usecase.port.out.BookingRepositoryPort;
import com.medic.appmedic.infrastructure.persistence.entity.BookingJpaEntity;
import com.medic.appmedic.infrastructure.persistence.jpa.BookingRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


public class BookingRepositoryAdapter implements BookingRepositoryPort {
    private final BookingRepository bookingRepository;

    public BookingRepositoryAdapter(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking save(Booking booking) {
        BookingJpaEntity entity = toEntity(booking);
        BookingJpaEntity saved = bookingRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Booking> findById(UUID id) {
        return bookingRepository.findById(id).map(this::toDomain);
    }

    private BookingJpaEntity toEntity(Booking booking) {
        BookingJpaEntity entity = new BookingJpaEntity();
        entity.setId(booking.getId());
        entity.setClientId(booking.getClientId());
        entity.setServiceId(booking.getServiceId());
        entity.setUserId(booking.getUserId());
        entity.setScheduledAt(booking.getScheduledAt());
        entity.setStatus(booking.getStatus());
        entity.setReason(booking.getReason());
        entity.setNotes(booking.getNotes());
        entity.setCreatedAt(booking.getCreatedAt());
        entity.setUpdatedAt(booking.getUpdatedAt());
        return entity;
    }

    private Booking toDomain(BookingJpaEntity entity) {
        Booking booking = new Booking();
        booking.setId(entity.getId());
        booking.setClientId(entity.getClientId());
        booking.setServiceId(entity.getServiceId());
        booking.setUserId(entity.getUserId());
        booking.setScheduledAt(entity.getScheduledAt());
        booking.setStatus(entity.getStatus());
        booking.setReason(entity.getReason());
        booking.setNotes(entity.getNotes());
        booking.setCreatedAt(entity.getCreatedAt());
        booking.setUpdatedAt(entity.getUpdatedAt());
        return booking;
    }
}

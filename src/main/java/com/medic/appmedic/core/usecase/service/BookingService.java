package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.entity.Booking;
import com.medic.appmedic.core.usecase.dto.request.CreateBookingRequest;
import com.medic.appmedic.core.usecase.dto.response.BookingResponse;
import com.medic.appmedic.core.usecase.port.in.CreateBookingCase;
import com.medic.appmedic.core.usecase.port.in.GetListBookingCase;
import com.medic.appmedic.core.usecase.port.out.BookingRepositoryPort;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService implements CreateBookingCase, GetListBookingCase {
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
    public List<BookingResponse> execute(){
        List<Booking> bookings = bookingRepositoryPort.findAllBooking();
        return bookings.stream().map(
                booking -> new BookingResponse(
                        booking.getId(),
                        booking.getClientId(),
                        booking.getServiceId(),
                        booking.getUserId(),
                        booking.getScheduledAt(),
                        booking.getStatus(),
                        booking.getReason(),
                        booking.getNotes(),
                        booking.getCreatedAt(),
                        booking.getUpdatedAt()
                )
        ).toList();
    }

}

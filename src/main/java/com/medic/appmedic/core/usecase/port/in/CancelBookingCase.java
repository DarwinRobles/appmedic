package com.medic.appmedic.core.usecase.port.in;

import java.util.UUID;

import com.medic.appmedic.core.usecase.dto.response.BookingResponse;

public interface CancelBookingCase {
    BookingResponse cancelBooking(UUID id);
    
}

package com.medic.appmedic.core.usecase.port.in;

import com.medic.appmedic.core.usecase.dto.request.CreateBookingRequest;
import com.medic.appmedic.core.usecase.dto.response.BookingResponse;

public interface CreateBookingCase {
    BookingResponse createBooking(CreateBookingRequest request);
}

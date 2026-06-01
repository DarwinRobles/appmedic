package com.medic.appmedic.core.usecase.port.in;

import com.medic.appmedic.core.usecase.dto.response.BookingResponse;

import java.util.List;

public interface GetListBookingCase {
    List<BookingResponse> execute();
}

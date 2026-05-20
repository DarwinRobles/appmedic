package com.medic.appmedic.infrastructure.persistence.controller;

import com.medic.appmedic.core.usecase.dto.response.BookingResponse;
import com.medic.appmedic.core.usecase.port.in.GetListBookingCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final GetListBookingCase getListBookingCase;

    public BookingController(GetListBookingCase getListBookingCase) {
        this.getListBookingCase = getListBookingCase;
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getListBooking(){
        return ResponseEntity.ok(getListBookingCase.execute());
    }

}

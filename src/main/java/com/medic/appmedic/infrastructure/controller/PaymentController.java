package com.medic.appmedic.infrastructure.controller;


import com.medic.appmedic.core.usecase.dto.request.CreatePaymentRequest;
import com.medic.appmedic.core.usecase.dto.response.PaymentResponse;
import com.medic.appmedic.core.usecase.port.in.CreatePaymentCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final CreatePaymentCase createPaymentCase;

    // Constructor para la Inyección de Dependencias
    public PaymentController(CreatePaymentCase createPaymentCase) {
        this.createPaymentCase = createPaymentCase;
    }

    @PostMapping("/register")
    public ResponseEntity<PaymentResponse> registerPayment(@RequestBody CreatePaymentRequest request) {

        PaymentResponse response = createPaymentCase.createPayment(request);
        return ResponseEntity.ok(response);
    }
}

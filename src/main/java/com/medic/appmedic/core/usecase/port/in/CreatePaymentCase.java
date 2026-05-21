package com.medic.appmedic.core.usecase.port.in;

import com.medic.appmedic.core.usecase.dto.request.CreatePaymentRequest;
import com.medic.appmedic.core.usecase.dto.response.PaymentResponse;

public interface CreatePaymentCase {
    PaymentResponse createPayment(CreatePaymentRequest request);
}

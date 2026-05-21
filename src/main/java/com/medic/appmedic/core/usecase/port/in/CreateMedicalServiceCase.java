package com.medic.appmedic.core.usecase.port.in;

import com.medic.appmedic.core.usecase.dto.request.CreateMedicalServiceRequest;
import com.medic.appmedic.core.usecase.dto.response.MedicalServiceResponse;

public interface CreateMedicalServiceCase {
    MedicalServiceResponse createMedicalService(CreateMedicalServiceRequest request);
}

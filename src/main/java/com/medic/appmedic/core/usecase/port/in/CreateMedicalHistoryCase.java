package com.medic.appmedic.core.usecase.port.in;

import com.medic.appmedic.core.usecase.dto.request.CreateMedicalHistoryRequest;
import com.medic.appmedic.core.usecase.dto.response.MedicalHistoryResponse;

public interface CreateMedicalHistoryCase {
    MedicalHistoryResponse createMedicalHistory(CreateMedicalHistoryRequest request);
}

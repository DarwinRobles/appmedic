package com.medic.appmedic.core.usecase.port.in;

import com.medic.appmedic.core.usecase.dto.response.MedicalServiceResponse;

import java.util.List;

public interface GetListMedicalServiceCase {
    List<MedicalServiceResponse> getListMedicalService();
}

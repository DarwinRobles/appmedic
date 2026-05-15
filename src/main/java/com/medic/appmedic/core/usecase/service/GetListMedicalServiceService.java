package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.usecase.dto.response.MedicalServiceResponse;
import com.medic.appmedic.core.usecase.port.in.GetListMedicalServiceCase;
import com.medic.appmedic.core.usecase.port.out.MedicalServiceRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class GetListMedicalServiceService implements GetListMedicalServiceCase {

    private final MedicalServiceRepositoryPort medicalServiceRepositoryPort;

    public GetListMedicalServiceService(MedicalServiceRepositoryPort medicalServiceRepositoryPort) {
        this.medicalServiceRepositoryPort = medicalServiceRepositoryPort;
    }

    @Override
    public List<MedicalServiceResponse> getListMedicalService() {
        return medicalServiceRepositoryPort.findAll()
                .stream()
                .map(ms -> new MedicalServiceResponse(
                        ms.getId(),
                        ms.getName(),
                        ms.getDescription(),
                        ms.getDurationMinutes(),
                        ms.getPrice(),
                        ms.getActive()
                ))
                .collect(Collectors.toList());
    }
}
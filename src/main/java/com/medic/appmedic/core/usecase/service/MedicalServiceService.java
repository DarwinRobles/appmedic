package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.entity.MedicalService;
import com.medic.appmedic.core.usecase.dto.request.CreateMedicalServiceRequest;
import com.medic.appmedic.core.usecase.dto.response.MedicalServiceResponse;
import com.medic.appmedic.core.usecase.port.in.CreateMedicalServiceCase;
import com.medic.appmedic.core.usecase.port.out.MedicalServiceRepositoryPort;

import org.springframework.stereotype.Service;


public class MedicalServiceService implements CreateMedicalServiceCase {
    private final MedicalServiceRepositoryPort medicalServiceRepositoryPort;

    public MedicalServiceService(MedicalServiceRepositoryPort medicalServiceRepositoryPort) {
        this.medicalServiceRepositoryPort = medicalServiceRepositoryPort;
    }

    @Override
    public MedicalServiceResponse createMedicalService(CreateMedicalServiceRequest request) {
        MedicalService medicalService = new MedicalService();
        medicalService.setName(request.getName());
        medicalService.setDescription(request.getDescription());
        medicalService.setDurationMinutes(request.getDurationMinutes());
        medicalService.setPrice(request.getPrice());
        medicalService.setActive(request.getActive() != null ? request.getActive() : Boolean.TRUE);

        MedicalService saved = medicalServiceRepositoryPort.save(medicalService);

        return new MedicalServiceResponse(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.getDurationMinutes(),
                saved.getPrice(),
                saved.getActive()
        );
    }
}

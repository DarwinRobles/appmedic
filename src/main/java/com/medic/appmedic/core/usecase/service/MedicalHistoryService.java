package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.entity.MedicalHistory;
import com.medic.appmedic.core.usecase.dto.request.CreateMedicalHistoryRequest;
import com.medic.appmedic.core.usecase.dto.response.MedicalHistoryResponse;
import com.medic.appmedic.core.usecase.port.in.CreateMedicalHistoryCase;
import com.medic.appmedic.core.usecase.port.out.MedicalHistoryRepositoryPort;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class MedicalHistoryService implements CreateMedicalHistoryCase {
    private final MedicalHistoryRepositoryPort medicalHistoryRepositoryPort;

    public MedicalHistoryService(MedicalHistoryRepositoryPort medicalHistoryRepositoryPort) {
        this.medicalHistoryRepositoryPort = medicalHistoryRepositoryPort;
    }

    @Override
    public MedicalHistoryResponse createMedicalHistory(CreateMedicalHistoryRequest request) {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setClientId(request.getClientId());
        medicalHistory.setBookingId(request.getBookingId());
        medicalHistory.setUserId(request.getUserId());
        medicalHistory.setDiagnosis(request.getDiagnosis());
        medicalHistory.setTreatment(request.getTreatment());
        medicalHistory.setObservations(request.getObservations());
        medicalHistory.setRecordedAt(Instant.now());

        MedicalHistory saved = medicalHistoryRepositoryPort.save(medicalHistory);

        return new MedicalHistoryResponse(
                saved.getId(),
                saved.getClientId(),
                saved.getBookingId(),
                saved.getUserId(),
                saved.getDiagnosis(),
                saved.getTreatment(),
                saved.getObservations(),
                saved.getRecordedAt()
        );
    }
}

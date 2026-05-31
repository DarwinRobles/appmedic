package com.medic.appmedic.infrastructure.persistence.adapter;

import com.medic.appmedic.core.entity.MedicalHistory;
import com.medic.appmedic.core.usecase.port.out.MedicalHistoryRepositoryPort;
import com.medic.appmedic.infrastructure.persistence.entity.MedicalHistoryJpaEntity;
import com.medic.appmedic.infrastructure.persistence.jpa.MedicalHistoryRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


public class MedicalHistoryRepositoryAdapter implements MedicalHistoryRepositoryPort {
    private final MedicalHistoryRepository medicalHistoryRepository;

    public MedicalHistoryRepositoryAdapter(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    @Override
    public MedicalHistory save(MedicalHistory medicalHistory) {
        MedicalHistoryJpaEntity entity = toEntity(medicalHistory);
        MedicalHistoryJpaEntity saved = medicalHistoryRepository.save(entity);
        return toDomain(saved);
    }


    @Override
    public Optional<MedicalHistory> findById(UUID id) {
        return medicalHistoryRepository.findById(id).map(this::toDomain);
    }

    private MedicalHistoryJpaEntity toEntity(MedicalHistory medicalHistory) {
        MedicalHistoryJpaEntity entity = new MedicalHistoryJpaEntity();
        entity.setId(medicalHistory.getId());
        entity.setClientId(medicalHistory.getClientId());
        entity.setBookingId(medicalHistory.getBookingId());
        entity.setUserId(medicalHistory.getUserId());
        entity.setDiagnosis(medicalHistory.getDiagnosis());
        entity.setTreatment(medicalHistory.getTreatment());
        entity.setObservations(medicalHistory.getObservations());
        entity.setRecordedAt(medicalHistory.getRecordedAt());
        return entity;
    }

    private MedicalHistory toDomain(MedicalHistoryJpaEntity entity) {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setId(entity.getId());
        medicalHistory.setClientId(entity.getClientId());
        medicalHistory.setBookingId(entity.getBookingId());
        medicalHistory.setUserId(entity.getUserId());
        medicalHistory.setDiagnosis(entity.getDiagnosis());
        medicalHistory.setTreatment(entity.getTreatment());
        medicalHistory.setObservations(entity.getObservations());
        medicalHistory.setRecordedAt(entity.getRecordedAt());
        return medicalHistory;
    }
}

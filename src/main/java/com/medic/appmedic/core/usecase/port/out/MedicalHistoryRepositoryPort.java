package com.medic.appmedic.core.usecase.port.out;

import com.medic.appmedic.core.entity.MedicalHistory;

import java.util.Optional;
import java.util.UUID;

public interface MedicalHistoryRepositoryPort {
    MedicalHistory save(MedicalHistory medicalHistory);

    Optional<MedicalHistory> findById(UUID id);
}

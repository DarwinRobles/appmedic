package com.medic.appmedic.core.usecase.port.out;

import com.medic.appmedic.core.entity.MedicalService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicalServiceRepositoryPort {
    MedicalService save(MedicalService medicalService);

    Optional<MedicalService> findById(UUID id);
    List<MedicalService> findAll();
}

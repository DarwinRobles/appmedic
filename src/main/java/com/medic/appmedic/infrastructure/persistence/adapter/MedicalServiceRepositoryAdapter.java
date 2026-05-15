package com.medic.appmedic.infrastructure.persistence.adapter;

import com.medic.appmedic.core.entity.MedicalService;
import com.medic.appmedic.core.usecase.port.out.MedicalServiceRepositoryPort;
import com.medic.appmedic.infrastructure.persistence.entity.MedicalServiceJpaEntity;
import com.medic.appmedic.infrastructure.persistence.jpa.MedicalServiceRepository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class MedicalServiceRepositoryAdapter implements MedicalServiceRepositoryPort {
    private final MedicalServiceRepository medicalServiceRepository;

    public MedicalServiceRepositoryAdapter(MedicalServiceRepository medicalServiceRepository) {
        this.medicalServiceRepository = medicalServiceRepository;
    }

    @Override
    public MedicalService save(MedicalService medicalService) {
        MedicalServiceJpaEntity entity = toEntity(medicalService);
        MedicalServiceJpaEntity saved = medicalServiceRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<MedicalService> findById(UUID id) {
        return medicalServiceRepository.findById(id).map(this::toDomain);
    }

    private MedicalServiceJpaEntity toEntity(MedicalService medicalService) {
        MedicalServiceJpaEntity entity = new MedicalServiceJpaEntity();
        entity.setId(medicalService.getId());
        entity.setName(medicalService.getName());
        entity.setDescription(medicalService.getDescription());
        entity.setDurationMinutes(medicalService.getDurationMinutes());
        entity.setPrice(medicalService.getPrice());
        entity.setActive(medicalService.getActive());
        return entity;
    }

    private MedicalService toDomain(MedicalServiceJpaEntity entity) {
        MedicalService medicalService = new MedicalService();
        medicalService.setId(entity.getId());
        medicalService.setName(entity.getName());
        medicalService.setDescription(entity.getDescription());
        medicalService.setDurationMinutes(entity.getDurationMinutes());
        medicalService.setPrice(entity.getPrice());
        medicalService.setActive(entity.getActive());
        return medicalService;
    }
    @Override
    public List<MedicalService> findAll() {
        return medicalServiceRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(toList());
    }
}

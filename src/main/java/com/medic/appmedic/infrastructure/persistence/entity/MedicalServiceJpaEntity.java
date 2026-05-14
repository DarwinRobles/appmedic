package com.medic.appmedic.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "medical_services")
public class MedicalServiceJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private Integer durationMinutes;
    private BigDecimal price;
    private Boolean active;

    public MedicalServiceJpaEntity() {}
}

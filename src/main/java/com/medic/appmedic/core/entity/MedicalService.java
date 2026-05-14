package com.medic.appmedic.core.entity;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MedicalService {
    private UUID id;
    private String name;
    private String description;
    private Integer durationMinutes;
    private BigDecimal price;
    private Boolean active;

    public MedicalService() {}
}

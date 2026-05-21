package com.medic.appmedic.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class MedicalServiceResponse {
    private UUID id;
    private String name;
    private String description;
    private Integer durationMinutes;
    private BigDecimal price;
    private Boolean active;

    public MedicalServiceResponse(
            UUID id,
            String name,
            String description,
            Integer durationMinutes,
            BigDecimal price,
            Boolean active
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.price = price;
        this.active = active;
    }
}

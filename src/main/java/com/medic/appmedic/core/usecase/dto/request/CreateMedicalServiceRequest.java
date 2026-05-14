package com.medic.appmedic.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateMedicalServiceRequest {
    private String name;
    private String description;
    private Integer durationMinutes;
    private BigDecimal price;
    private Boolean active;

    public CreateMedicalServiceRequest(
            String name,
            String description,
            Integer durationMinutes,
            BigDecimal price,
            Boolean active
    ) {
        this.name = name;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.price = price;
        this.active = active;
    }
}

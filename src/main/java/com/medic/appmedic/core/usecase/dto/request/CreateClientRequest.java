package com.medic.appmedic.core.usecase.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateClientRequest {
    private String fullName;
    private String email;
    private String phone;
    private String documentId;
    private LocalDate birthDate;
    private String address;
    private String notes;
    private LocalDate createdAt;
    private LocalDate updatedAt;


    public CreateClientRequest(
            String fullName,
            String email,
            String phone,
            String documentId,
            LocalDate birthDate,
            String address,
            String notes,
            LocalDate createdAt,
            LocalDate updatedAt
    ) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.documentId = documentId;
        this.birthDate = birthDate;
        this.address = address;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

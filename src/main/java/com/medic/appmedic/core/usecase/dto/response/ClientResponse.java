package com.medic.appmedic.core.usecase.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ClientResponse {
    private UUID id;
    private String fullName;
    private String email;
    private String phone;
    private String documentId;
    private LocalDate birthDate;
    private String address;
    private String notes;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public ClientResponse(
            UUID id,
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
        this.id = id;
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

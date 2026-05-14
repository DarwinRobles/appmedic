package com.medic.appmedic.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Client {
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

    public Client() {}
}

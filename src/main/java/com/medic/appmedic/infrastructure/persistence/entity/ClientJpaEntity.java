package com.medic.appmedic.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class ClientJpaEntity {

    @Id
    @GeneratedValue
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

    public ClientJpaEntity() {}
}

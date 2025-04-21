package com.marceloconti.backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient extends BaseEntity {

    @Column(nullable = false, length = 100)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @Max(100)
    private Integer age;

    @Column(nullable = false, unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "^\\+?[0-9]{10,15}$")
    @NotBlank
    private String phoneNumber;

    @Column(nullable = false, length = 15)
    @NotBlank
    private String gender;

    private String address;

    @Column(nullable = false)
    @NotBlank
    private String emergencyContactName;

    @Column(nullable = false)
    @NotBlank
    private String emergencyContactPhone;

    @Pattern(regexp = "^(A|B|AB|O)[+-]?$", message = "Invalid blood type")
    private String bloodType;

    @Size(max = 1000)
    private String allergies;

    @Size(max = 1000)
    private String chronicDiseases;

    @Size(max = 1000)
    private String currentMedications;

    @Size(max = 1000)
    private String notes;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
}

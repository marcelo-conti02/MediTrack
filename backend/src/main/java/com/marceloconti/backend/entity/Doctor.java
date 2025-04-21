package com.marceloconti.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors", indexes = {
        @Index(name = "idx_doctor_email", columnList = "email"),
        @Index(name = "idx_doctor_specialty", columnList = "specialty")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor extends BaseEntity {
    @Column(nullable = false, length = 100)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    private String specialty;

    @Column(nullable = false)
    @Min(18)
    @Max(100)
    private Integer age;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$")
    private String phoneNumber;

    private String hospital;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
}

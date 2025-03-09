package com.marceloconti.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}

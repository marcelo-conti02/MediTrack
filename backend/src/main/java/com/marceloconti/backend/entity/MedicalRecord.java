package com.marceloconti.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicalRecord extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private LocalDate visitDate;

    @Column(length = 1000)
    private String visitReason;

    @Column(length = 1000)
    private String diagnosis;

    @Column(length = 1000)
    private String treatment;

    @Column(length = 1000)
    private String prescription;

    @Column(length = 1000)
    private String followUpInstructions;

    private LocalDate followUpDate;

    private Boolean requiresFollowUp;

    private Boolean isEmergency;

    @Column(length = 1000)
    private String labResults;

    @Column(length = 1000)
    private String imagingResults;

    @Column(length = 1000)
    private String notes;
}

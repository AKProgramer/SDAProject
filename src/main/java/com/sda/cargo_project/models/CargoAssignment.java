package com.sda.cargo_project.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cargo_assignments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id", unique = true, nullable = false)
    private Cargo cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private User driver;

    @Column(name = "assignment_date", nullable = false)
    private LocalDateTime assignmentDate;

    // Constructors


    // Getters and Setters
}

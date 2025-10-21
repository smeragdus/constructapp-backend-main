package com.novahabitat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Actividades
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idActivity;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean status;

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_ACTIVITY_EMPLOYEE") )
    private Employee employee;

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_project", nullable = false, foreignKey = @ForeignKey(name = "FK_ACTIVITY_PROJECT") )
    private Project project;
}

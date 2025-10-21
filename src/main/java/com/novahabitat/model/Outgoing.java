package com.novahabitat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Gastos
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Outgoing {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOutgoing;

    private LocalDate outgoingDate;
    private String outgoingType;
    private Double amount;
    private String detail;

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_project", nullable = false, foreignKey = @ForeignKey(name = "FK_OUTGOING_PROJECT") )
    private Project project;
}

package com.novahabitat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// Maquinaria
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Machinery {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMachinery;

    private String name;
    private String machineryType;
    private boolean status;
    private String actualLocation;

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_project", nullable = false, foreignKey = @ForeignKey(name = "FK_MACHINERY_PROJECT") )
    private Project project;
}

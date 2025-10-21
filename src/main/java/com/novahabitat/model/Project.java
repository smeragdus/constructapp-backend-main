package com.novahabitat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int idProject;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 200)
    private String location;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date estimatedEndDate;

    @Column(nullable = false)
    private String status; // En elaboracion, En proceso, En ejecución, Parada

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_customer", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_CUSTOMER") )
    private Customer customer;

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_USER") )
    private User user;
}

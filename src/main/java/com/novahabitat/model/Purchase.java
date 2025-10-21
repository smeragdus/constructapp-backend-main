package com.novahabitat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Compras
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Purchase {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPurchase;

    private LocalDate purchaseDate;
    private Integer quantity;
    private Double totalCost;

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_material", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_MATERIAL"))
    private Material material;

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_project", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_PROJECT"))
    private Project project;

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_supplier", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_SUPPLIER"))
    private Supplier supplier;
}

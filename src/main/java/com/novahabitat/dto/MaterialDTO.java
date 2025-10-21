package com.novahabitat.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MaterialDTO {
    private Integer idMaterial;

    @NotNull
    @Size(min=3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String name;

    @NotNull
    @Size(min=1, max = 50, message = "La unidad de medida debe tener entre 1 y 50 caracteres")
    private String measurementUnit; // unidad de medida

    @DecimalMin(value = "0.01", message = "El precio unitario debe ser mayor a 0")
    @NotNull(message = "El precio unitario es obligatorio")
    private Double unitPrice;

    @Min(value = 0, message = "El stock actual no puede ser negativo")
    @NotNull(message = "El stock actual es obligatorio")
    private Integer actualStock;

    // Para la relación: Solo necesitamos el ID del proveedor.
    @NotNull(message = "El ID del proveedor es obligatorio")
    private Integer idSupplier;

    // Opcional: Podrías añadir el nombre del proveedor para "Read"
    // private String supplierName;
}
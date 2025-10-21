package com.novahabitat.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private int idCustomer;

    @NotNull // Te olvidaste del campo o no enviaste nada
    //@NotEmpty // Cuando envías vacío
    //@NotBlank // Espacios en blanco
    @Size(min=3, max = 70)
    private String firstName;

    @NotNull
    @Size(min=3, max = 70)
    private String lastName;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    private String phone;

    @Email
    private String email;

    @NotNull
    private String dni; // DNI /CE / RUC

    private String address;

    /*@Min(value = 0)
    @Max(value=70)
    private int edad;
     */
}

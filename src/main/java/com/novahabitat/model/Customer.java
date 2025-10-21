package com.novahabitat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor // Constructor sin parámetros
@AllArgsConstructor // Constructor con parametros
@Data // getters, setters
@Entity
//@Table(name="clientes", schema="ventas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;

    @Column(nullable = false, length = 70)//, name="nombres")
    private String firstName;

    @Column(nullable = false, length = 70)
    private String lastName;

    @Column(length = 30)
    private String phone;

    @Column(length = 60)
    private String email;

    @Column(nullable = false, length = 30)
    private String dni; // DNI /CE / RUC

    @Column(length = 150)
    private String address;

    /*
    public Customer() {
    }*/

    /*public Customer(int idCustomer, String name) {
        this.idCustomer = idCustomer;
        this.name = name;
    }*/

    /*
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}

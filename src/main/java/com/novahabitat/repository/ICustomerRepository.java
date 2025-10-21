package com.novahabitat.repository;

import com.novahabitat.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
public interface ICustomerRepository extends IGenericRepository<Customer, Integer> {
    //Customer save(Customer customer );
}

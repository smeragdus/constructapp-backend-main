package com.novahabitat.repository;

import com.novahabitat.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {// implements ICustomerRepository{
    //@Override
    public Customer save(Customer customer ){
        System.out.println("Customer save to database");
        return customer;
    }
}

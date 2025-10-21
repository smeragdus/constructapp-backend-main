package com.novahabitat.service.implementation;

import com.novahabitat.model.Customer;
import com.novahabitat.repository.ICustomerRepository;
import com.novahabitat.repository.IGenericRepository;
import com.novahabitat.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService extends GenericService<Customer, Integer> implements ICustomerService {
    //@Autowired
    private final ICustomerRepository repo;

    @Override
    protected IGenericRepository<Customer, Integer> getRepo() {
        return repo;
    }

}

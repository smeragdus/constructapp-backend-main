package com.novahabitat.service.implementation;

import com.novahabitat.model.Supplier;
import com.novahabitat.repository.IGenericRepository;
import com.novahabitat.repository.ISupplierRepository;
import com.novahabitat.service.ISupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierService extends GenericService<Supplier, Integer> implements ISupplierService {
    private final ISupplierRepository repo;

    @Override
    protected IGenericRepository<Supplier, Integer> getRepo() {
        return repo;
    }
}

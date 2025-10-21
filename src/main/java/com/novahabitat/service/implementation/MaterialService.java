package com.novahabitat.service.implementation;

import com.novahabitat.model.Material;
import com.novahabitat.repository.IGenericRepository;
import com.novahabitat.repository.IMaterialRepository;
import com.novahabitat.service.IMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialService extends GenericService<Material, Integer> implements IMaterialService {

    private final IMaterialRepository repo;

    @Override
    protected IGenericRepository<Material, Integer> getRepo() {
        return repo;
    }
}
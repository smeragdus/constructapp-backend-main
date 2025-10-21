package com.novahabitat.service.implementation;

import com.novahabitat.model.Project;
import com.novahabitat.repository.IGenericRepository;
import com.novahabitat.repository.IProjectRepository;
import com.novahabitat.service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService extends GenericService<Project, Integer> implements IProjectService {
    private final IProjectRepository repo;

    @Override
    protected IGenericRepository<Project, Integer> getRepo() {
        return repo;
    }
}

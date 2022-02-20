package com.second.secondproject.service.impl;

import com.second.secondproject.model.Project;
import com.second.secondproject.repository.ContributorRepository;
import com.second.secondproject.repository.ProjectRepository;
import com.second.secondproject.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveProject(Project projectRequest) {
        return projectRepository.save(projectRequest);
    }
}

package com.second.secondproject.controller;

import com.second.secondproject.model.Project;
import com.second.secondproject.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // save project
    @PostMapping
    public ResponseEntity<Project> saveProject(@RequestBody Project projectRequest) {
        return new ResponseEntity<Project>(projectService.saveProject(projectRequest), HttpStatus.CREATED);
    }
}

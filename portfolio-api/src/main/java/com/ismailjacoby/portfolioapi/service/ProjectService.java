package com.ismailjacoby.portfolioapi.service;

import com.ismailjacoby.portfolioapi.models.entity.Project;
import com.ismailjacoby.portfolioapi.models.form.ProjectForm;

import java.util.List;

public interface ProjectService {
    void createProject(ProjectForm form);
    Project getProjectById(Long id);
    List<Project> getAllProjects();
    void updateProject(Long id, ProjectForm form);
    void deleteProject(Long id);
}

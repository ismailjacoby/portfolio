package com.ismailjacoby.portfolioapi.service.impl;

import com.ismailjacoby.portfolioapi.exception.NotFoundException;
import com.ismailjacoby.portfolioapi.models.entity.Project;
import com.ismailjacoby.portfolioapi.models.entity.Skill;
import com.ismailjacoby.portfolioapi.models.form.ProjectForm;
import com.ismailjacoby.portfolioapi.repository.ProjectRepository;
import com.ismailjacoby.portfolioapi.repository.SkillRepository;
import com.ismailjacoby.portfolioapi.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, SkillRepository skillRepository) {
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public void createProject(ProjectForm form) {
        List<Skill> technologies  = skillRepository.findAllById(form.technologies());

        if (technologies.size() != form.technologies().size()) {
            throw new NotFoundException("Some technologies were not found.");
        }

        Project project = new Project();
        project.setTitle(form.title().trim());
        project.setDescription(form.description());
        project.setImageUrl(form.imageUrl().trim());
        project.setDemoUrl(form.demoUrl() != null ? form.demoUrl().trim() : null);
        project.setCodeUrl(form.codeUrl() != null ? form.codeUrl().trim() : null);
        project.setPublic(form.isPublic());
        project.setTechnologies(technologies);

        projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project with id '" + id + "' not found"));
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void updateProject(Long id, ProjectForm form) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project with id '" + id + "' not found"));

        project.setTitle(form.title().trim());
        project.setDescription(form.description());
        project.setImageUrl(form.imageUrl().trim());
        project.setDemoUrl(form.demoUrl() != null ? form.demoUrl().trim() : null);
        project.setCodeUrl(form.codeUrl() != null ? form.codeUrl().trim() : null);
        project.setPublic(form.isPublic());

        List<Skill> technologies = skillRepository.findAllById(form.technologies());

        if (technologies.size() != form.technologies().size()) {
            throw new NotFoundException("One or more skills not found");
        }

        project.setTechnologies(technologies);
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new NotFoundException("Project with id '" + id + "' not found");
        }
        projectRepository.deleteById(id);
    }
}

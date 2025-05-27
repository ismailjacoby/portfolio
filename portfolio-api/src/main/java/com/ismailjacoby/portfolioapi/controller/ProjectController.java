package com.ismailjacoby.portfolioapi.controller;

import com.ismailjacoby.portfolioapi.models.dto.ProjectDTO;
import com.ismailjacoby.portfolioapi.models.entity.Project;
import com.ismailjacoby.portfolioapi.models.form.ProjectForm;
import com.ismailjacoby.portfolioapi.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<String> createProject(@RequestBody @Valid ProjectForm form) {
        projectService.createProject(form);
        return ResponseEntity.ok("Project created successfully.");
    }

    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok(ProjectDTO.fromEntity(project));
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projects = projectService.getAllProjects().stream()
                .map(ProjectDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(projects);
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProject(@PathVariable Long id, @RequestBody @Valid ProjectForm form) {
        projectService.updateProject(id, form);
        return ResponseEntity.ok("Project updated successfully.");
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project deleted successfully.");
    }
}

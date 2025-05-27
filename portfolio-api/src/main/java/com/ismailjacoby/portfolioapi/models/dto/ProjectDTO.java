package com.ismailjacoby.portfolioapi.models.dto;

import com.ismailjacoby.portfolioapi.models.entity.Project;
import com.ismailjacoby.portfolioapi.models.entity.Skill;

import java.util.List;

public record ProjectDTO(
        String title,
        String description,
        String imageUrl,
        String demoUrl,
        String codeUrl,
        boolean isPublic,
        List<SkillDTO> technologies
) {
    public static ProjectDTO fromEntity(Project project) {
        List<SkillDTO> skillDTOs = project.getTechnologies().stream()
                .map(SkillDTO::fromEntity)
                .toList();

        return new ProjectDTO (
                project.getTitle(),
                project.getDescription(),
                project.getImageUrl(),
                project.getDemoUrl(),
                project.getCodeUrl(),
                project.isPublic(),
                skillDTOs
        );
    }
}

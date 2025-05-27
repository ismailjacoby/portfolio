package com.ismailjacoby.portfolioapi.models.dto;

import com.ismailjacoby.portfolioapi.models.entity.Skill;
import com.ismailjacoby.portfolioapi.models.enums.SkillCategory;

public record SkillDTO(
        String name,
        SkillCategory category
) {
    public static SkillDTO fromEntity(Skill skill) {
        return new SkillDTO (
                skill.getName(),
                skill.getCategory()
        );
    }
}

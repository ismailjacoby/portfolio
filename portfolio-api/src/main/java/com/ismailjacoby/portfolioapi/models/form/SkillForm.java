package com.ismailjacoby.portfolioapi.models.form;

import com.ismailjacoby.portfolioapi.models.enums.SkillCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SkillForm (
        @NotBlank(message = "Please provide a name for the skill.")
        @Size(min = 1, max = 30, message = "Skill name must be between 1 and 30 characters.")
        String name,

        @NotNull(message = "Please select a skill category (e.g., Frontend, Backend, Tools).")
        SkillCategory category
) {
}

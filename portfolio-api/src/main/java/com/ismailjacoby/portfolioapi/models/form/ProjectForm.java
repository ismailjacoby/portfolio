package com.ismailjacoby.portfolioapi.models.form;

import com.ismailjacoby.portfolioapi.models.entity.Skill;
import jakarta.validation.constraints.*;

import java.util.List;

public record ProjectForm (
        @NotBlank(message = "Project title is required.")
        @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters.")
        String title,

        @NotBlank(message = "Project description is required.")
        @Size(max = 500, message = "Description must be at most 500 characters.")
        String description,

        @NotBlank(message = "An image URL is required to showcase the project.")
        @Size(max = 255, message = "Image URL must be at most 255 characters.")
        @Pattern(regexp = "^(https?://).+", message = "Image URL must be a valid URL starting with http or https.")
        String imageUrl,

        @Size(max = 255, message = "Demo URL must be at most 255 characters.")
        @Pattern(regexp = "^(https?://).+", message = "Demo URL must be a valid URL starting with http or https.")
        String demoUrl,

        @Size(max = 255, message = "Code URL must be at most 255 characters.")
        @Pattern(regexp = "^(https?://).+", message = "Code URL must be a valid URL starting with http or https.")
        String codeUrl,


        boolean isPublic,

        @NotEmpty(message = "Please select at least one technology used in the project.")
        List<@NotNull(message = "Technology ID must not be null.") Long> technologies
) {
}


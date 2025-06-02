package com.ismailjacoby.portfolioapi.models.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactForm(
        @NotBlank(message = "First name is required.")
        String firstName,

        @NotBlank(message = "Last name is required.")
        String lastName,

        @NotBlank(message = "First name is required.")
        @Email(message = "Invalid email format.")
        String email,

        String company,

        @NotBlank(message = "Subject is required.")
        String subject,

        @NotBlank(message = "Message is required")
        @Size(min = 10, message = "Message should have at least 10 characters.")
        String message

) {
}

package com.ismailjacoby.portfolioapi.models.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LoginForm(
        @NotBlank(message = "Username cannot be blank.")
        @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
        String username,

        @NotBlank(message = "Password cannot be null.")
        @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[_#?!@=$ %^&*-]).{8,}$",
                message = "Password must be at least 8 characters long, include one uppercase letter, one lowercase letter, one number and one special character")
        String password) {
}

package com.ismailjacoby.portfolioapi.models.dto;

import com.ismailjacoby.portfolioapi.models.enums.UserRole;
import lombok.Builder;

@Builder
public record AuthDTO(
        String username,
        String token,
        UserRole role
) {
}

package com.eyubx.bookingsystem.api.dto;

import jakarta.validation.constraints.NotBlank;

public record ExpertSearchRequestDTO (
    String name,
    @NotBlank(message = "expertise is required")
    String expertise
) {
}

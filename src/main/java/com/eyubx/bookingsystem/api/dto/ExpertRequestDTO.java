package com.eyubx.bookingsystem.api.dto;

import com.eyubx.bookingsystem.entity.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ExpertRequestDTO (
    String name,

    @NotBlank(message = "expertise is required")
    String expertise,

    String description,

    String email,

    String phone,

    @NotNull(message = "account is required to assign to expert profile")
    Long userId
) {
}

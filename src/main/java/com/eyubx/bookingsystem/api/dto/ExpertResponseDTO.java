package com.eyubx.bookingsystem.api.dto;

import java.util.List;

public record ExpertResponseDTO (
        Long id,
        String name,
        String expertise,
        String description,
        String email,
        String phone,
        UserSummaryDTO user,
        List<String> availableHours
) {
}


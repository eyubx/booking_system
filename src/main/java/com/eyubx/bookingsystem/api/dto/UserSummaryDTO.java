package com.eyubx.bookingsystem.api.dto;

public record UserSummaryDTO (
        Long id,
        String username,
        String email
) {}

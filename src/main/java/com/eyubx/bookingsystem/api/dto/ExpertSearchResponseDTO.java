package com.eyubx.bookingsystem.api.dto;

public record ExpertSearchResponseDTO (
        Long id,
        String name,
        String expertise,
        String description,
        String email,
        String phone
){
}

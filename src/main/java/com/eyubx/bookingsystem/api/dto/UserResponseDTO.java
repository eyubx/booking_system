package com.eyubx.bookingsystem.api.dto;

import com.eyubx.bookingsystem.entity.Role;
import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        Role role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}

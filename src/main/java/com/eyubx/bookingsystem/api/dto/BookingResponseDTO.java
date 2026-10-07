package com.eyubx.bookingsystem.api.dto;

import java.time.LocalDate;

public record BookingResponseDTO(
        Long id,
        String key,
        ExpertSummaryDTO expert,
        String name,
        String email,
        String note,
        LocalDate bookingDate,
        String timeSlot
) {
}

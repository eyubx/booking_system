package com.eyubx.bookingsystem.api.controller;

import com.eyubx.bookingsystem.api.dto.BookingResponseDTO;
import com.eyubx.bookingsystem.entity.Booking;
import com.eyubx.bookingsystem.repository.BookingRepository;
import com.eyubx.bookingsystem.service.BookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@Tag(name="Booking Controller")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/expert/{expertId}")
    public List<BookingResponseDTO> getBookingByExpert(@PathVariable Long expertId) {
        return bookingService.getBookingByExpert(expertId);
    }


}

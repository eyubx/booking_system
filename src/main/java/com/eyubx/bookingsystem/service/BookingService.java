package com.eyubx.bookingsystem.service;

import com.eyubx.bookingsystem.api.dto.BookingResponseDTO;
import com.eyubx.bookingsystem.api.dto.ExpertResponseDTO;
import com.eyubx.bookingsystem.api.dto.ExpertSummaryDTO;
import com.eyubx.bookingsystem.entity.Booking;
import com.eyubx.bookingsystem.entity.Expert;
import com.eyubx.bookingsystem.repository.BookingRepository;
import com.eyubx.bookingsystem.repository.ExpertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ExpertRepository expertRepository;

    public BookingService(BookingRepository bookingRepository, ExpertRepository expertRepository) {
        this.bookingRepository = bookingRepository;
        this.expertRepository = expertRepository;
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findByBookingId(long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking findByKey(String key) {
        return bookingRepository.findByKey(key).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public List<BookingResponseDTO> getBookingByExpert(Long expertId) {
        return bookingRepository.findByExpertId(expertId)
                .stream().map(item ->
                    new BookingResponseDTO(
                        item.getId(),
                        item.getKey(),
                        new ExpertSummaryDTO(
                            item.getExpert().getId(),
                            item.getExpert().getName(),
                            item.getExpert().getExpertise()
                        ),
                        item.getName(),
                        item.getEmail(),
                        item.getNote(),
                        item.getBookingDate(),
                        item.getTimeSlot()
                    )
                ).toList();
    }
}

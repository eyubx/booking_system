package com.eyubx.bookingsystem.repository;

import com.eyubx.bookingsystem.entity.Booking;
import com.eyubx.bookingsystem.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    Optional<Booking> findByKey(String key);

    List<Booking> findByExpertId(Long expertId);
}

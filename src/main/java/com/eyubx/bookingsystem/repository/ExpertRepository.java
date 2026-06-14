package com.eyubx.bookingsystem.repository;

import com.eyubx.bookingsystem.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpertRepository extends JpaRepository<Expert, Long> {

    List<Expert> findByNameContainingIgnoreCaseAndExpertiseContainingIgnoreCase(String name, String expertise);

}

package com.eyubx.bookingsystem.service;

import com.eyubx.bookingsystem.api.dto.*;
import com.eyubx.bookingsystem.entity.Expert;
import com.eyubx.bookingsystem.entity.User;
import com.eyubx.bookingsystem.repository.ExpertRepository;
import com.eyubx.bookingsystem.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
public class ExpertService {
    private final ExpertRepository expertRepo;
    private final UserRepository userRepo;

    public  ExpertService(ExpertRepository expertRepo, UserRepository userRepo) {
        this.expertRepo = expertRepo;
        this.userRepo = userRepo;
    }
    
    public List<ExpertSearchResponseDTO> searchExperts(String name, String expertise) {
        String n = name != null ? name.trim() : "";
        String e = expertise != null ? expertise.trim() : "";

        return expertRepo
                .findByNameContainingIgnoreCaseAndExpertiseContainingIgnoreCase(n, e)
                .stream()
                .map(item -> new ExpertSearchResponseDTO(
                        item.getId(),
                        item.getName(),
                        item.getExpertise(),
                        item.getDescription(),
                        item.getEmail(),
                        item.getPhone()
                ))
                .toList();
    }

    public ExpertResponseDTO createExpert(@Valid ExpertRequestDTO request) {
        User user = userRepo.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Expert expert = new Expert();
        expert.setName(request.name()).setDescription(request.description())
            .setExpertise(request.expertise())
            .setEmail(request.email())
            .setPhone(request.phone())
            .setUser(user)
            .setAvailableHours(List.of("09:00","10:00","11:00","14:00","15:00","16:00","17:00"));
        Expert savedExpert = expertRepo.save(expert);
        return new ExpertResponseDTO(
            savedExpert.getId(),
            savedExpert.getName(),
            savedExpert.getExpertise(),
            savedExpert.getDescription(),
                savedExpert.getEmail(),
                savedExpert.getPhone(),
                new UserSummaryDTO(
                        savedExpert.getUser().getId(),
                        savedExpert.getUser().getUsername(),
                        savedExpert.getUser().getEmail()
                ),
                savedExpert.getAvailableHours()
        );
    }

    public List<ExpertResponseDTO> getExperts() {
        return expertRepo.findAll().stream()
            .map(expert -> new ExpertResponseDTO(
                expert.getId(),
                expert.getName(),
                expert.getExpertise(),
                expert.getDescription(),
                expert.getEmail(),
                expert.getPhone(),
                expert.getUser() != null ? new UserSummaryDTO(
                    expert.getUser().getId(),
                    expert.getUser().getUsername(),
                    expert.getUser().getEmail()
                ) : null,
                expert.getAvailableHours()
            )).toList();
    }

    public ExpertResponseDTO getExpertById(Long id) {
        Optional<Expert> expert = expertRepo.findById(id);
        if (expert.isEmpty())
            throw new RuntimeException("Expert not found");

        return new ExpertResponseDTO(
            expert.get().getId(),
            expert.get().getName(),
            expert.get().getExpertise(),
            expert.get().getDescription(),
            expert.get().getEmail(),
            expert.get().getPhone(),
            expert.get().getUser() != null ? new UserSummaryDTO(
                expert.get().getUser().getId(),
                expert.get().getUser().getUsername(),
                expert.get().getUser().getEmail()
            ) : null,
            expert.get().getAvailableHours()
        );
    }

    public ExpertResponseDTO updateExpert(Long id, ExpertRequestDTO request) {
        Expert expert = expertRepo.findById(id).orElseThrow(() -> new RuntimeException("Expert not found"));
        if (request.name() != null)
            expert.setName(request.name());
        if (request.description() != null)
            expert.setDescription(request.description());
        if (request.email() != null)
            expert.setEmail(request.email());
        if (request.phone() != null)
            expert.setPhone(request.phone());
        if (request.userId() != null) {
            User user = userRepo.findById(request.userId()).orElseThrow(() -> new RuntimeException("User not found"));
            expert.setUser(user);
        }
        // TODO : when change to TimeSlot entity, add the condition here
        Expert savedExpert = expertRepo.save(expert);
        return new ExpertResponseDTO(
            savedExpert.getId(),
            savedExpert.getName(),
            savedExpert.getExpertise(),
            savedExpert.getDescription(),
            savedExpert.getEmail(),
            savedExpert.getPhone(),
            new UserSummaryDTO(
                savedExpert.getUser().getId(),
                savedExpert.getUser().getUsername(),
                savedExpert.getUser().getEmail()
            ),
            savedExpert.getAvailableHours()
        );
    }
}

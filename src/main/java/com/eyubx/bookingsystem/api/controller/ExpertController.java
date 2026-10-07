package com.eyubx.bookingsystem.api.controller;

import com.eyubx.bookingsystem.api.dto.ExpertRequestDTO;
import com.eyubx.bookingsystem.api.dto.ExpertResponseDTO;
import com.eyubx.bookingsystem.api.dto.ExpertSearchRequestDTO;
import com.eyubx.bookingsystem.api.dto.ExpertSearchResponseDTO;
import com.eyubx.bookingsystem.service.ExpertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/experts")
@Tag(name = "Expert Controller", description = "Create, Read, Update and Delete.")
public class ExpertController {
    private final ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping("/")
    public List<ExpertResponseDTO> getExperts() {
        return expertService.getExperts();
    }

    @GetMapping("/search")
    public List<ExpertSearchResponseDTO> searchExperts(@Valid @ModelAttribute ExpertSearchRequestDTO request) {
        return expertService.searchExperts(request.name(), request.expertise());
    }

    @PostMapping("/")
    public ResponseEntity<ExpertResponseDTO> addExpert(@Valid @RequestBody ExpertRequestDTO request) {
        return ResponseEntity.ok(expertService.createExpert(request));
    }

    @GetMapping("/{id}")
    public ExpertResponseDTO getExpert(@PathVariable Long id) {
        return expertService.getExpertById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExpertResponseDTO> updateExpert(@PathVariable Long id, @RequestBody ExpertRequestDTO request) {
        return ResponseEntity.ok(expertService.updateExpert(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExpertResponseDTO> deleteExpert(@PathVariable Long id) {
        expertService.deleteExpert(id);
        return  ResponseEntity.noContent().build();
    }
}

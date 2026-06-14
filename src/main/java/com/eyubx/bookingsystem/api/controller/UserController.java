package com.eyubx.bookingsystem.api.controller;

import com.eyubx.bookingsystem.api.dto.UserRequestDTO;
import com.eyubx.bookingsystem.api.dto.UserResponseDTO;
import com.eyubx.bookingsystem.entity.User;
import com.eyubx.bookingsystem.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Controller", description = "operations related to the User")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        // list all experts in here with
        return userService.getUsers();
    }

    @PostMapping(path = "/create-admin")
    public ResponseEntity<UserResponseDTO> createAdmin(@Valid @RequestBody UserRequestDTO user) {
        UserResponseDTO response = userService.createAdmin(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public boolean login(@Valid @RequestBody UserRequestDTO user) {
        return true;
    }

    // for testing only
    @PostMapping("/users/bulk")
    public List<UserResponseDTO> bulk(@Valid @RequestBody List<UserRequestDTO> requests) {
        return userService.createBulkUsers(requests);
    }
}

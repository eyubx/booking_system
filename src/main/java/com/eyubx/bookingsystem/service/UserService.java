package com.eyubx.bookingsystem.service;

import com.eyubx.bookingsystem.api.dto.UserRequestDTO;
import com.eyubx.bookingsystem.api.dto.UserResponseDTO;
import com.eyubx.bookingsystem.entity.Role;
import com.eyubx.bookingsystem.entity.User;
import com.eyubx.bookingsystem.exception.AppException;
import com.eyubx.bookingsystem.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public UserResponseDTO createAdmin(UserRequestDTO userDto) {
        if (userRepository.count() > 0)
            throw new AppException(HttpStatus.FORBIDDEN, "Admin already exists");
        User user = new User();
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setRole(Role.ADMIN);
        User saved = userRepository.save(user);
        return new UserResponseDTO(
                saved.getId(), saved.getUsername(), saved.getEmail(),
                saved.getRole(), saved.getCreatedAt(), saved.getUpdatedAt()
        );
    }

    public List<UserResponseDTO> createBulkUsers(List<UserRequestDTO> requests) {
        return requests.stream().map(request -> {
            User user = new User();
            user.setUsername(request.username());
            user.setEmail(request.email());
            user.setPassword(passwordEncoder.encode(request.password()));
            user.setRole(Role.USER);
            User saved = userRepository.save(user);
            return new UserResponseDTO(
                saved.getId(),
                saved.getUsername(),
                saved.getEmail(),
                saved.getRole(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
            );
        }).toList();
    }

}

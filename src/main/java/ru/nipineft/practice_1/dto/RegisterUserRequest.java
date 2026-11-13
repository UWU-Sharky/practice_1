package ru.nipineft.practice_1.dto;

import jakarta.validation.constraints.*;

public record RegisterUserRequest(
        @Email @NotBlank String email,
        @Size(min = 8, max = 100) String password
) {}
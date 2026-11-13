package ru.nipineft.practice_1.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateAuthorRequest(
        @NotBlank String fullName,
        LocalDate birthDate
) {}

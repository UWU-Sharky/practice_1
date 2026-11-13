package ru.nipineft.practice_1.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AuthorDto(
        Long id,
        String fullName,
        LocalDate birthDate
) {}


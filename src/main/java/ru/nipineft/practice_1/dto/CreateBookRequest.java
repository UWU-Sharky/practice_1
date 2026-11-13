package ru.nipineft.practice_1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateBookRequest(
        @NotBlank String title,
        @Positive Integer publicationYear,
        Long publisherId,
        @NotEmpty List<Long> authorIds,
        List<Long> genreIds
) {}

package ru.nipineft.practice_1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record BookDto(
        Long id,
        String title,
        Integer publicationYear,
        PublisherDto publisher,
        List<AuthorDto> authors,
        List<GenreDto> genres
) {}


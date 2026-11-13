package ru.nipineft.practice_1.dto;

import jakarta.validation.constraints.NotBlank;

public record CreatePublisherRequest(
        @NotBlank String name
) {}

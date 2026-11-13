// dto/CreateGenreRequest.java
package ru.nipineft.practice_1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateGenreRequest(
        @NotBlank @Size(max = 100) String name
) {}
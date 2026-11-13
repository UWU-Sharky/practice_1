package ru.nipineft.practice_1.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nipineft.practice_1.dto.CreateGenreRequest;
import ru.nipineft.practice_1.dto.GenreDto;
import ru.nipineft.practice_1.service.GenreService;

import java.util.List;

// controller/GenreController.java
@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping                       // все объекты таблицы
    public List<GenreDto> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public GenreDto getById(@PathVariable Long id) {
        return genreService.getById(id);
    }

    @PostMapping                      // создание объекта
    @ResponseStatus(HttpStatus.CREATED)
    public GenreDto create(@Valid @RequestBody CreateGenreRequest request) {
        return genreService.create(request);
    }

    @PutMapping("/{id}")
    public GenreDto update(@PathVariable Long id,
                           @Valid @RequestBody CreateGenreRequest request) {
        return genreService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        genreService.delete(id);
    }

    // Просто проверка коммитов
}
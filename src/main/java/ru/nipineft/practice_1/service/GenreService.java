package ru.nipineft.practice_1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nipineft.practice_1.dto.CreateGenreRequest;
import ru.nipineft.practice_1.dto.GenreDto;
import ru.nipineft.practice_1.exception.NotFoundException;
import ru.nipineft.practice_1.model.Genre;
import ru.nipineft.practice_1.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional(readOnly = true)
    public List<GenreDto> getAll() {
        return genreRepository.findAll().stream().map(GenreService::toDto).toList();
    }

    @Transactional
    public GenreDto create(CreateGenreRequest request) {
        Genre genre = new Genre();
        genre.setName(request.name());
        return toDto(genreRepository.save(genre));
    }

    @Transactional
    public GenreDto update(Long id, CreateGenreRequest request) {
        Genre genre = find(id);
        genre.setName(request.name());   // сохранится сам при коммите транзакции
        return toDto(genre);
    }

    @Transactional
    public void delete(Long id) {
        genreRepository.delete(find(id));
    }

    @Transactional(readOnly = true)
    public GenreDto getById(Long id) {
        return toDto(find(id));
    }

    private Genre find(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Жанр", id));
    }

    static GenreDto toDto(Genre g) {
        return new GenreDto(g.getId(), g.getName());
    }
}
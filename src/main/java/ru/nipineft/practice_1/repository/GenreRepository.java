package ru.nipineft.practice_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nipineft.practice_1.model.Genre;
import ru.nipineft.practice_1.model.Publisher;

public interface GenreRepository extends JpaRepository<Genre, Long> {}
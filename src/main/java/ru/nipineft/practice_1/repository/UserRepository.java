package ru.nipineft.practice_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nipineft.practice_1.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);   // для логина
    boolean existsByEmail(String email);        // проверка при регистрации
}
package ru.nipineft.practice_1.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity, Long id) {
        super("Не найдено: " + entity + " с id = " + id);
    }
}
package ru.nipineft.practice_1.exception;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super("Пользователь", id);
    }
}
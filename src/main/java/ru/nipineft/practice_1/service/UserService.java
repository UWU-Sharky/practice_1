package ru.nipineft.practice_1.service;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import ru.nipineft.practice_1.dto.RegisterUserRequest;
import ru.nipineft.practice_1.dto.UserDto;
import ru.nipineft.practice_1.exception.EmailAlreadyExistsException;
import ru.nipineft.practice_1.exception.UserNotFoundException;
import ru.nipineft.practice_1.model.User;
import ru.nipineft.practice_1.repository.UserRepository;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional
    public UserDto getById(Long id) {
        return userRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Transactional
    public UserDto create(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }
        User user = new User(request.email(), request.password());
        return toDto(userRepository.save(user));
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    private UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getEmail());
    }

}

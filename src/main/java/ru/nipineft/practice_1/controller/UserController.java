package ru.nipineft.practice_1.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nipineft.practice_1.dto.RegisterUserRequest;
import ru.nipineft.practice_1.dto.UserDto;
import ru.nipineft.practice_1.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/book")
class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@Valid @RequestBody RegisterUserRequest request)
    {
        return userService.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)
    {
        userService.delete(id);
    }


}

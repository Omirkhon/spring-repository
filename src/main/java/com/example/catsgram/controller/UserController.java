package com.example.catsgram.controller;

import com.example.catsgram.model.User;
import com.example.catsgram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> findAll(@RequestParam LocalDate birthdate) {
        if (birthdate == null) {
            return userService.findAll();
        }
        log.debug("GET /users?birthdate=2000-05-12");
        return userService.findUserByBirthDate(birthdate);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        log.debug("POST /users {}", user);
        return userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        log.debug("PUT /users {}", user);
        return userService.update(user);
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
}

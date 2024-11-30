package com.example.catsgram.controller;

import com.example.catsgram.exceptions.InvalidEmailException;
import com.example.catsgram.exceptions.UserAlreadyExistException;
import com.example.catsgram.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {
    private final HashMap<String, User> users = new HashMap<>();

    @GetMapping
    public HashMap<String, User> findAll() {
        return users;
    }

    @PostMapping
    public User create(@RequestBody User user) throws Exception {
        if (users.containsKey(user.getEmail()))
            throw new UserAlreadyExistException();
        if (user.getEmail() == null)
            throw new InvalidEmailException();
        users.put(user.getEmail(), user);
        return user;
    }

    @PutMapping
    public User update(@RequestBody User user) {
        users.put(user.getEmail(), user);
        return user;
    }
}

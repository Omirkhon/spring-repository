package com.example.catsgram.controller;

import com.example.catsgram.exceptions.InvalidEmailException;
import com.example.catsgram.exceptions.UserAlreadyExistException;
import com.example.catsgram.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final HashMap<String, User> users = new HashMap<>();

    @GetMapping
    public List<User> findAll() {
        List<User> listOfUsers = new ArrayList<>(users.values());
        return listOfUsers;
    }

    @PostMapping
    public User create(@RequestBody User user) throws Exception {
        if (user.getEmail() == null)
            throw new InvalidEmailException();
        if (users.containsKey(user.getEmail()))
            throw new UserAlreadyExistException();
        users.put(user.getEmail(), user);
        return user;
    }

    @PutMapping
    public User update(@RequestBody User user) {
        users.put(user.getEmail(), user);
        return user;
    }
}

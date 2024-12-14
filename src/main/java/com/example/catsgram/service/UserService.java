package com.example.catsgram.service;

import com.example.catsgram.exceptions.InvalidEmailException;
import com.example.catsgram.exceptions.UserAlreadyExistException;
import com.example.catsgram.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    private final HashMap<String, User> users = new HashMap<>();

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User create(User user) throws RuntimeException{
        if (user.getEmail() == null)
            throw new InvalidEmailException();
        if (users.containsKey(user.getEmail()))
            throw new UserAlreadyExistException();
        users.put(user.getEmail(), user);
        return user;
    }

    public User update(User user) {
        users.put(user.getEmail(), user);
        return user;
    }

    public User findUserByEmail(String email) {
        return users.get(email);
    }
}

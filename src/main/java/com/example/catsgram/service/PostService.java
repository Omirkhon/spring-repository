package com.example.catsgram.service;

import com.example.catsgram.exceptions.UserNotFoundException;
import com.example.catsgram.model.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class PostService {
    private int uniqueId = 1;
    private final List<Post> posts = new ArrayList<>();
    private UserService userService;

    public PostService(UserService userService) {
        this.userService = userService;
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post create(Post post) {
        String email = post.getAuthor();

        if (userService.findUserByEmail(email) == null) {
            throw new UserNotFoundException("Пользователь " + email + " не найден.");
        }

        post.setId(uniqueId++);
        posts.add(post);
        return post;
    }

    public Post findById(int postId) {
        return posts.get(postId);
    }
}

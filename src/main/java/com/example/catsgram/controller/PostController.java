package com.example.catsgram.controller;

import com.example.catsgram.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final List<Post> posts = new ArrayList<>();

    @GetMapping
    public List<Post> findAll() {
        return posts;
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }
}

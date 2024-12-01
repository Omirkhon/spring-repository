package com.example.catsgram.controller;

import com.example.catsgram.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    private final List<Post> posts = new ArrayList<>();

    @GetMapping
    public List<Post> findAll() {
        log.debug("Текущее количество постов: " + posts.size());
        return posts;
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }
}

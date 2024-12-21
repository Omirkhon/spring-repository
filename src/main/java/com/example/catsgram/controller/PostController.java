package com.example.catsgram.controller;

import com.example.catsgram.model.Post;
import com.example.catsgram.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@Slf4j
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<Post> findAll(
            @RequestParam(required = false) @DefaultValue("desc") String sort,
            @RequestParam(required = false) @DefaultValue("10") Integer size,
            @RequestParam(required = false) @DefaultValue("0") Integer page) {
        log.debug("GET /posts");
        return postService.findAll(sort, size, page);
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        log.debug("POST /posts {}", post);
        return postService.create(post);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable int postId) {
        return postService.findById(postId);
    }
}

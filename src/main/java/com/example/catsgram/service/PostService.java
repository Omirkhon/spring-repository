package com.example.catsgram.service;

import com.example.catsgram.exceptions.UserNotFoundException;
import com.example.catsgram.model.Post;
import com.example.catsgram.utils.DateComparator;
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

    public List<Post> findAll(String sort, Integer size, Integer page) {
        if (posts.isEmpty()) {
            return posts;
        }

        if (sort.equals("asc")) {
            posts.sort(new DateComparator());
        } else if (sort.equals("desc")) {
            posts.sort(new DateComparator().reversed());
        }

        List<List<Post>> newPosts = new ArrayList<>();

        for (int i = 0; i <= size; i++) {
            List<Post> tempPosts = new ArrayList<>();

            for (int j = posts.size()/size * i; j < posts.size()/size + posts.size()/size * i; j++) {
                tempPosts.add(posts.get(j));
            }
            newPosts.add(tempPosts);
        }

        return newPosts.get(page);
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

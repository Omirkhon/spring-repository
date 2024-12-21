package com.example.catsgram.utils;

import com.example.catsgram.model.Post;
import java.util.Comparator;

public class DateComparator implements Comparator<Post> {
    @Override
    public int compare(Post p1, Post p2) {
        if (p1.getCreationDate().isAfter(p2.getCreationDate())) {
            return 1;
        } else if (p1.getCreationDate().isBefore(p2.getCreationDate())){
            return -1;
        } else {
            return 0;
        }
    }
}

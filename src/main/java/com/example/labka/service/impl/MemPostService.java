package com.example.labka.service.impl;

import com.example.labka.dto.Post;
import com.example.labka.service.api.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemPostService implements PostService {

    private ArrayList<Post> posts = new ArrayList<Post>(Arrays.asList(
            Post.builder()
                    .title("BMW M5")
                    .body("2014, 4.4 liter, 575 hp")
                    .img("/img/1.jpg")
                    .build(),
            Post.builder()
                    .title("Mercedes-Benz G63 AMG")
                    .body("2015, 5.5 liter, 544 hp")
                    .img("/img/2.jpg")
                    .build(),
            Post.builder()
                    .title("BMW M4")
                    .body("2015, 3.0 liter, 431 hp")
                    .img("/img/3.jpg")
                    .build(),
            Post.builder()
                    .title("BMW M2")
                    .body("2017, 3.0 liter, 370 hp")
                    .img("/img/4.jpg")
                    .build()
    ));


    @Override
    public List<Post> search(String query) {
        return query != null && !query.isEmpty() ?
                posts.stream().filter(post ->
                post.getTitle().toLowerCase().matches(".*" + query.toLowerCase() + ".*"))
                .collect(Collectors.toList())
                :
                posts;
    }
}

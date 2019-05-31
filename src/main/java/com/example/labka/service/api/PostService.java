package com.example.labka.service.api;

import com.example.labka.dto.Post;

import java.util.List;

public interface PostService {
    List<Post> search(String query);
}

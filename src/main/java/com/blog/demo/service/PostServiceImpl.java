package com.blog.demo.service;

import com.blog.demo.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Override
    public PostDto createPost(PostDto postDto) {
        return null;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

    @Override
    public PostDto getPostById(Long id) {
        return null;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        return null;
    }

    @Override
    public void deletePostById(Long id) {

    }
}


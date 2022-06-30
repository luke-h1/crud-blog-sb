package com.blog.demo.service.impl;

import com.blog.demo.entity.Comment;
import com.blog.demo.entity.Post;
import com.blog.demo.exception.ResourceNotFoundException;
import com.blog.demo.payload.CommentDto;
import com.blog.demo.repository.CommentRepository;
import com.blog.demo.repository.PostRepository;
import com.blog.demo.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        comment.setPost(post);

        Comment newComment = commentRepository.save(comment);
        return mapToDto(newComment);


    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        return null;
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        return null;
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest) {
        return null;
    }

    @Override
    public void deleteComment(Long commentId, Long postId) {

    }

    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }
}

package com.example.cookbookproject.service.impl;

import com.example.cookbookproject.entity.CommentEntity;
import com.example.cookbookproject.model.Comment;
import com.example.cookbookproject.repository.CommentRepository;
import com.example.cookbookproject.service.CommentService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public void save(Integer id, Comment comment) {
        commentRepository.save(new CommentEntity(comment.getContent(), comment.getUserName(), id));
    }


//    @Override
//    public Comment addComment(String content, String userName, Recipe recipe) {
//        Comment comment = new Comment(content, userName, recipe);
//        commentRepository.save(comment);
//        return comment;
//    }


    @Override
    public List<CommentEntity> recipeComments(Integer recipeId) {
        return commentRepository.findByRecipeId(recipeId);
    }
}



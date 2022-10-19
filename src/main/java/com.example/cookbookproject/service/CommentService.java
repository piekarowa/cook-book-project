package com.example.cookbookproject.service;

import com.example.cookbookproject.entity.CommentEntity;
import com.example.cookbookproject.model.Comment;

import java.util.List;

public interface CommentService {


    void save(Integer id, Comment comment);

//    Comment addComment(String content, String userName, Recipe recipe);

    public List<CommentEntity> recipeComments(Integer recipeId);
}
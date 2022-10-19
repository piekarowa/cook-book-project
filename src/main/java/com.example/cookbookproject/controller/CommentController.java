package com.example.cookbookproject.controller;


import com.example.cookbookproject.model.Comment;
import com.example.cookbookproject.model.Recipe;
import com.example.cookbookproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CommentController {


    private CommentService commentService;



    public CommentController(CommentService commentService) {
        this.commentService = commentService;

    }

    @GetMapping("/recipes/{id}/comments/create")
    public String showCommentForm(@PathVariable Integer id, ModelMap modelMap, Recipe recipe) {
        modelMap.addAttribute("emptyComment", new Comment());
        modelMap.addAttribute("id", recipe.getId());
        return "comment-create";
    }


    @PostMapping("/recipes/{id}/comments/save")
    public String handleNewComment(@PathVariable Integer id, @ModelAttribute("emptyComment") Comment comment) {
        log.info("Handle new comment: " + comment);

        commentService.save(id, comment);
        return "redirect:/recipe-details";
    }

}



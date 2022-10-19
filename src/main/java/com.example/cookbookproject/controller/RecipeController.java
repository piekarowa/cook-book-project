package com.example.cookbookproject.controller;


import com.example.cookbookproject.entity.RecipeEntity;
import com.example.cookbookproject.model.Recipe;
import com.example.cookbookproject.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;
    public RecipeController (RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("admin/recipes/create")
    public String showRecipeForm(ModelMap modelMap) {
        modelMap.addAttribute("emptyRecipe", new Recipe());
        return "recipe-create";
    }

    @PostMapping("admin/recipes/save")
    public String handleNewRecipe(@ModelAttribute("emptyRecipe") Recipe recipe) {
        recipeService.save(recipe);
        return "redirect:/";
    }

    @RequestMapping(path = {"/","/search"})
    public String showRecipes(RecipeEntity recipe, ModelMap modelMap, String keyword) {
        if(keyword != null){
            List<RecipeEntity> recipes = recipeService.findByKeyword(keyword);
            modelMap.addAttribute("recipes", recipes);
        } else {
            List<RecipeEntity> recipes = recipeService.getAll();
            modelMap.addAttribute("recipes", recipes);
            }

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        modelMap.addAttribute("currentUser", currentUser);

        return "recipe-list";
    }
    @GetMapping("/recipes/{id}")
    public String recipeDetails(@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("recipe", recipeService.getById(id));
        return "recipe-details";
    }
    @GetMapping("admin/recipes/delete/{id}")
    public String deleteBook(@PathVariable Integer id){
        log.info("deleted Recipe by id with  " + id);
        recipeService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("admin/recipes/edit/{id}")
    public String showEditRecipeForm(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("recipe", recipeService.getById(id));
        return "recipe-edit";
    }

    @PostMapping("admin/recipes/update")
    public String handleUpdatedRecipe(@ModelAttribute("recipe") Recipe recipe, Errors errors) {
        log.info("Handle recipe to update: " + recipe);

        if (errors.hasErrors()) {
            log.error("Errors form frontend: " + errors.getFieldErrors());
            return "recipe-edit";
        }

        recipeService.save(recipe);
        return "redirect:/";
    }

}

package com.example.cookbookproject.service.impl;



import com.example.cookbookproject.entity.RecipeEntity;
import com.example.cookbookproject.model.Recipe;
import com.example.cookbookproject.repository.RecipeRepository;
import com.example.cookbookproject.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void save(Recipe recipe) {
        recipeRepository.save(new RecipeEntity(recipe.getId(), recipe.getRecipeName(),
                recipe.getDescription(),
                recipe.getIngredients(),
                recipe.getDirections(),
                recipe.getTag(),
                recipe.getReleaseDate()));
    }

    @Override
    public List<RecipeEntity> getAll() {
        List<RecipeEntity> recipes = (List<RecipeEntity>) recipeRepository.findAll();
        return recipes;
    }


    @Override
    public void deleteById(Integer id) {
        recipeRepository.deleteById(id);
    }

    public void update(Recipe recipe) {
        recipeRepository.save(new RecipeEntity(recipe.getId(),
                recipe.getRecipeName(),
                recipe.getDescription(),
                recipe.getIngredients(),
                recipe.getDirections(),
                recipe.getTag(),
                recipe.getReleaseDate()));
    }


    @Override
    public RecipeEntity getById(Integer id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<RecipeEntity> findByKeyword(String keyword) {
        return recipeRepository.findByKeyword(keyword);
    }


}

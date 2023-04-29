package io.undefvar.recipeService.services;

import io.undefvar.recipeService.dtos.RecipeDto;
import io.undefvar.recipeService.dtos.SaveRecipeRequestDto;
import io.undefvar.recipeService.dtos.UpdateRecipeRequestDto;

import java.rmi.NotBoundException;
import java.util.List;

public interface RecipeService {

    String saveRecipe(SaveRecipeRequestDto saveRecipeRequestDto);
    String updateRecipe(UpdateRecipeRequestDto updateRecipeRequestDto);
    List<RecipeDto> getAllRecipes();
    RecipeDto getRecipeById(String recipeId);

    String deleteRecipeById(String recipeId);

}

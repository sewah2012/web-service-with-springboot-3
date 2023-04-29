package io.undefvar.recipeService.dtos;

import io.undefvar.recipeService.domains.Ingredient;

import java.util.List;

public record SaveRecipeRequestDto(
        String recipeName,
        String recipeDescription,
        List<Ingredient> ingredientList
) {
}

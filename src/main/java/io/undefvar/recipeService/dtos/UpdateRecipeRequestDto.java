package io.undefvar.recipeService.dtos;

import io.undefvar.recipeService.domains.Ingredient;

import java.util.List;
import java.util.UUID;

public record UpdateRecipeRequestDto(
        UUID recipeId,
        String recipeName,
        String recipeDescription,
        List<Ingredient> ingredientList
) {
}

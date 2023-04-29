package io.undefvar.recipeService.mappers;

import io.undefvar.recipeService.domains.Recipe;
import io.undefvar.recipeService.dtos.RecipeDto;
import io.undefvar.recipeService.dtos.SaveRecipeRequestDto;
import io.undefvar.recipeService.dtos.UpdateRecipeRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    Recipe mapToRecipe(SaveRecipeRequestDto saveRecipeRequestDto);

    RecipeDto mapToRecipeDto(Recipe recipe);

    List<RecipeDto> mapToRecipeDtoList(List<Recipe> recipeList);

    Recipe updateRecipe(UpdateRecipeRequestDto updateRecipeRequestDto, @MappingTarget Recipe savedRecipe);
}

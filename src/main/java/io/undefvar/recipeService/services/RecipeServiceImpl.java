package io.undefvar.recipeService.services;

import io.undefvar.recipeService.domains.Recipe;
import io.undefvar.recipeService.dtos.RecipeDto;
import io.undefvar.recipeService.dtos.SaveRecipeRequestDto;
import io.undefvar.recipeService.dtos.UpdateRecipeRequestDto;
import io.undefvar.recipeService.mappers.RecipeMapper;
import io.undefvar.recipeService.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.NotBoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService{
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    @Override
    public String saveRecipe(SaveRecipeRequestDto saveRecipeRequestDto) {
        var isExisting = recipeRepository.findByRecipeName(saveRecipeRequestDto.recipeName()).isPresent();

        if(isExisting) throw new RuntimeException("Recipe already exists");
        var aftermapping = recipeMapper.mapToRecipe(saveRecipeRequestDto);
        log.info("after mapping: "+ aftermapping);
        recipeRepository.save(aftermapping);
        return "Recipe Successfully Saved";
    }

    @Override
    public String updateRecipe(UpdateRecipeRequestDto updateRecipeRequestDto) {
        Recipe savedRecipe = recipeRepository.findById(updateRecipeRequestDto.recipeId()).orElseThrow();
        Recipe updatedRecipe = recipeMapper.updateRecipe(updateRecipeRequestDto, savedRecipe);

        recipeRepository.save(updatedRecipe);
        return "Recipe Successfully updated";
    }

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipeList = ( List<Recipe>) recipeRepository.findAll();
        return recipeMapper.mapToRecipeDtoList(recipeList);
    }

    @Override
    public RecipeDto getRecipeById(String recipeId) {
        Recipe savedRecipe = recipeRepository.findById(UUID.fromString(recipeId)).orElseThrow();
        return recipeMapper.mapToRecipeDto(savedRecipe);
    }

    @Override
    public String deleteRecipeById(String recipeId)  {
       Recipe savedRecipe = recipeRepository.findById(UUID.fromString(recipeId)).orElseThrow();
       recipeRepository.delete(savedRecipe);
        return "Successfully deleted Recipe";
    }
}

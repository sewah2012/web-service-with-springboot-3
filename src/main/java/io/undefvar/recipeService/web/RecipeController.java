package io.undefvar.recipeService.web;

import io.undefvar.recipeService.dtos.SaveRecipeRequestDto;
import io.undefvar.recipeService.dtos.UpdateRecipeRequestDto;
import io.undefvar.recipeService.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.NotBoundException;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService service;

    @GetMapping
    ResponseEntity<?> listAllRecipe(){
        return ResponseEntity.ok(service.getAllRecipes());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getRecipeById(@PathVariable("id") String recipeId){
        return ResponseEntity.ok(service.getRecipeById(recipeId));
    }

    @PostMapping
    ResponseEntity<?> saveRecipe(@RequestBody SaveRecipeRequestDto saveRecipeRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveRecipe(saveRecipeRequestDto));
    }

    @PutMapping
    ResponseEntity<?> updateRecipe(@RequestBody UpdateRecipeRequestDto updateRecipeRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.updateRecipe(updateRecipeRequestDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteRecipe(@PathVariable("id") String recipeId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteRecipeById(recipeId));
    }
}

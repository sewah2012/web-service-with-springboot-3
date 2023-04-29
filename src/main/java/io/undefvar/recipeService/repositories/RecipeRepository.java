package io.undefvar.recipeService.repositories;

import io.undefvar.recipeService.domains.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, UUID> {
    Optional<Recipe> findByRecipeName(String s);
}

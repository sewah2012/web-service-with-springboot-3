package io.undefvar.recipeService.domains;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table("recipes")
public class Recipe {
    @Id
    private UUID recipeId;
    private String recipeName;
    private String recipeDescription;

    @Builder.Default
    @MappedCollection(idColumn = "recipe_id", keyColumn = "recipe_key")
    private List<Ingredient> ingredientList = new ArrayList<>();
}

package io.undefvar.recipeService.domains;

import org.springframework.data.relational.core.mapping.Table;

@Table("ingredients")
public record Ingredient(
        String name,
        Integer quantity
) {
}

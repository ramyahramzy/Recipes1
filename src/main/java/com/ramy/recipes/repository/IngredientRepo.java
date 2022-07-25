package com.ramy.recipes.repository;

import com.ramy.recipes.model.Ingredient;
import com.ramy.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecipe(Recipe recipe);
    List<Ingredient> findByDescriptionContainingIgnoreCase(String description);
}

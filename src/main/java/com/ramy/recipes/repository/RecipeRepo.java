package com.ramy.recipes.repository;

import com.ramy.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe , Long> {
    public List<Recipe> getRecipeByServe(Integer serve  );
    public List<Recipe> getRecipeByVegetarian(boolean vegetarian  );
}

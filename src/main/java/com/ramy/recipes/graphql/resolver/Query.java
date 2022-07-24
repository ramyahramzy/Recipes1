package com.ramy.recipes.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ramy.recipes.model.Ingredient;
import com.ramy.recipes.model.Recipe;
import com.ramy.recipes.repository.IngredientRepo;
import com.ramy.recipes.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private RecipeRepo recipeRepo;
    private IngredientRepo ingredientRepo;
    @Autowired
    public Query(RecipeRepo recipeRepo, IngredientRepo ingredientRepo) {
        this.recipeRepo = recipeRepo;
        this.ingredientRepo = ingredientRepo;
    }

    public Iterable<Recipe> findAllRecipes() {
        return recipeRepo.findAll();
    }
    public Iterable<Ingredient> findAllIngredients() {
        return ingredientRepo.findAll();
    }
    public long countRecipe() {
        return recipeRepo.count();
    }
    public long countIngredients() {
        return ingredientRepo.count();
    }

}

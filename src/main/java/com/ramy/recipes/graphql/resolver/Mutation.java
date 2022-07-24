package com.ramy.recipes.graphql.resolver;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ramy.recipes.model.Ingredient;
import com.ramy.recipes.repository.IngredientRepo;
import com.ramy.recipes.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private RecipeRepo recipeRepo;
    private IngredientRepo ingredientRepo;
    @Autowired
    public Mutation(RecipeRepo recipeRepo, IngredientRepo ingredientRepo) {
        this.recipeRepo = recipeRepo;
        this.ingredientRepo = ingredientRepo;
    }


}

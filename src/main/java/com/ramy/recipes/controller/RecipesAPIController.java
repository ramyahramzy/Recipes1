package com.ramy.recipes.controller;

import com.ramy.recipes.exception.ResourceNotFoundException;
import com.ramy.recipes.model.Ingredient;
import com.ramy.recipes.model.Recipe;
import com.ramy.recipes.repository.IngredientRepo;
import com.ramy.recipes.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class RecipesAPIController {

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    IngredientRepo ingredientRepo;

    @GetMapping(value="/recipe/recipes")
    public List<Recipe> getRecipes(){
        List<Recipe> recipeList = recipeRepo.findAll();
        if(recipeList.size() ==0)
            throw new ResourceNotFoundException("No Recipe");
        return recipeList;
    }

    @GetMapping(value="/recipe/{id}")
    public Recipe getRecipes(@PathVariable long id){
        return recipeRepo.findById(id).get();
    }

    @GetMapping(value="/recipe/serve/{serve}")
    public List<Recipe> getRecipesByServe(@PathVariable int serve){
        return recipeRepo.getRecipeByServe(serve);
    }

    @GetMapping(value="/recipe/vegetarian/{vegetarian}")
    public List<Recipe> getRecipesByVegetarian(@PathVariable boolean vegetarian){
        return recipeRepo.getRecipeByVegetarian(vegetarian);
    }

    @PostMapping(value="/recipe/add")
    public Recipe saveRecipe(@RequestBody Recipe recipe){


        return saveRecipeInternal(recipe);
    }

    private Recipe saveRecipeInternal(Recipe recipe){
        for(Ingredient ingredient:recipe.getIngredients()){
            ingredient.setRecipe(recipe);

        }
        Recipe savedRecipe = recipeRepo.save(recipe);
        if(recipe.getIngredients() != null){

            for(Ingredient ingredient:recipe.getIngredients()){
                ingredient.setRecipe(savedRecipe);
                ingredientRepo.save(ingredient);
            }

        }
        return savedRecipe;
    }


    @PutMapping(value="/recipe/update/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe , @PathVariable long id){
        if( recipeRepo.findById(id).get() == null){
            throw new ResourceNotFoundException("No Recipe");
        }
        recipe.setRecipeId(id);
        return saveRecipe(recipe);

    }

    @DeleteMapping(value="/recipe/delete/{id}")
    public Recipe deleteRecipe(@PathVariable long id){
        Recipe deleted = recipeRepo.findById(id).get();
        recipeRepo.deleteById(id);
        return deleted;
    }




}

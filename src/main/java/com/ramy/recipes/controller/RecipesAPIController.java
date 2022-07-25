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

    @GetMapping(value = "/recipe/recipes")
    public List<Recipe> getRecipes() {
        List<Recipe> recipeList = recipeRepo.findAll();
        if (recipeList.size() == 0)
            throw new ResourceNotFoundException("No Recipe");
        return recipeList;
    }

    @GetMapping(value = "/recipe/{id}")
    public Recipe getRecipes(@PathVariable long id) {

        return recipeRepo.findById(id).get();
    }

    @GetMapping(value = "/recipe/serve/{serve}")
    public List<Recipe> getRecipesByServe(@PathVariable int serve) {
        return recipeRepo.getRecipeByServe(serve);
    }



    @GetMapping(value = "/recipe/search", params = {"vegetarian","serve","includeIngredient","instruction"})
    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(@RequestParam(required = false) Boolean vegetarian, @RequestParam(required = false)Integer serve, @RequestParam(required = false) String includeIngredient, @RequestParam(required = false) String instruction) {

        return recipeRepo.getRecipeByVegetarianAndServeAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(vegetarian,serve,includeIngredient,instruction);

    }



    @GetMapping(value = "/recipe/search" , params = {"vegetarian"})
    public List<Recipe> getRecipesByVegetarian(@RequestParam(required = false) Boolean vegetarian) {

        return recipeRepo.getRecipeByVegetarian(vegetarian);

    }

    @GetMapping(value = "/recipe/search" , params = {"includeIngredient"})
    public List<Recipe> getRecipeByIngredients_DescriptionContainingIgnoreCase(@RequestParam(required = false)String includeIngredient){
        return recipeRepo.getRecipeByIngredients_DescriptionContainingIgnoreCase(includeIngredient);
    }

    @GetMapping(value = "/recipe/search" , params = {"excludeIngredient"})
    public List<Recipe> getRecipeByIngredients_DescriptionNotContainingIgnoreCase(@RequestParam(required = false)String excludeIngredient){
        return recipeRepo.getRecipeByIngredients_DescriptionNotContainingIgnoreCase(excludeIngredient);
    }

    @GetMapping(value = "/recipe/search" , params = {"instruction"})
    public List<Recipe> getRecipeByInstructionContainingIgnoreCase( @RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByInstructionContainingIgnoreCase(instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"serve"})
    public List<Recipe> getRecipeByServe( @RequestParam(required = false)Integer serve){
        return recipeRepo.getRecipeByServe(serve);
    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","serve"})
    public List<Recipe> getRecipesByVegetarianAndServe(@RequestParam(required = false) Boolean vegetarian, @RequestParam(required = false) Integer serve) {

        return recipeRepo.getRecipeByVegetarianAndServe(vegetarian,serve);

    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","includeIngredient"})
    public List<Recipe> getRecipesByVegetarianAnd(@RequestParam(required = false) Boolean vegetarian, @RequestParam(required = false) String includeIngredient) {

        return recipeRepo.getRecipeByVegetarianAndIngredients_DescriptionContainingIgnoreCase(vegetarian,includeIngredient);

    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","excludeIngredient"})
    public List<Recipe> getRecipeByVegetarianAndIngredients_DescriptionNotContainingIgnoreCase(@RequestParam(required = false)boolean vegetarian,@RequestParam(required = false)String excludeIngredient){
        return recipeRepo.getRecipeByVegetarianAndIngredients_DescriptionNotContainingIgnoreCase(vegetarian,excludeIngredient);
    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","instruction"})
    public List<Recipe> getRecipeByVegetarianAndInstructionContainingIgnoreCase(@RequestParam(required = false)boolean vegetarian, @RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByVegetarianAndInstructionContainingIgnoreCase(vegetarian,instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"serve","includeIngredient"})
    public List<Recipe> getRecipeByServeAndIngredients_DescriptionContainingIgnoreCase(@RequestParam(required = false)int serve,@RequestParam(required = false)String includeIngredient){
        return recipeRepo.getRecipeByServeAndIngredients_DescriptionContainingIgnoreCase(serve,includeIngredient);
    }

    @GetMapping(value = "/recipe/search" , params = {"serve","excludeIngredient"})
    public List<Recipe> getRecipeByServeAndIngredients_DescriptionNotContainingIgnoreCase(@RequestParam(required = false)int serve,@RequestParam(required = false)String excludeIngredient){
        return recipeRepo.getRecipeByServeAndIngredients_DescriptionNotContainingIgnoreCase(serve,excludeIngredient);
    }

    @GetMapping(value = "/recipe/search" , params = {"serve","instruction"})
    public List<Recipe> getRecipeByServeAndInstructionContainingIgnoreCase(@RequestParam(required = false)int serve,@RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByServeAndInstructionContainingIgnoreCase(serve,instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"includeIngredient","instruction"})
    public List<Recipe> getRecipeByIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(@RequestParam(required = false)String includeIngredient,@RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(includeIngredient,instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"excludeIngredient","instruction"})
    public List<Recipe> getRecipeByIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(@RequestParam(required = false)String excludeIngredient,@RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(excludeIngredient,instruction);
    }



    @GetMapping(value = "/recipe/search" , params = {"vegetarian","serve","includeIngredient"})
    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionContainingIgnoreCase(@RequestParam(required = false)boolean vegetarian,@RequestParam(required = false)int serve,@RequestParam(required = false)String includeIngredient){
        return recipeRepo.getRecipeByVegetarianAndServeAndIngredients_DescriptionContainingIgnoreCase(vegetarian,serve,includeIngredient);
    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","serve","excludeIngredient"})
    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionNotContainingIgnoreCase(@RequestParam(required = false)boolean vegetarian,@RequestParam(required = false)int serve,@RequestParam(required = false)String excludeIngredient){
        return recipeRepo.getRecipeByVegetarianAndServeAndIngredients_DescriptionNotContainingIgnoreCase(vegetarian,serve,excludeIngredient);
    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","serve","instruction"})
    public List<Recipe> getRecipeByVegetarianAndServeAndInstructionContainingIgnoreCase(@RequestParam(required = false)boolean vegetarian,@RequestParam(required = false)int serve,@RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByVegetarianAndServeAndInstructionContainingIgnoreCase(vegetarian,serve,instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","includeIngredient","instruction"})
    public List<Recipe> getRecipeByVegetarianAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(@RequestParam(required = false)boolean vegetarian,@RequestParam(required = false)String includeIngredient,@RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByVegetarianAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(vegetarian,includeIngredient,instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","excludeIngredient","instruction"})
    public List<Recipe> getRecipeByVegetarianAndIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(@RequestParam(required = false)boolean vegetarian,@RequestParam(required = false)String excludeIngredient,@RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByVegetarianAndIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(vegetarian,excludeIngredient,instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"serve","includeIngredient","instruction"})
    public List<Recipe> getRecipeByServeAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(@RequestParam(required = false)int serve,@RequestParam(required = false)String includeIngredient,@RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByServeAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(serve,includeIngredient,instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"serve","excludeIngredient","instruction"})
    public List<Recipe> getRecipeByServeAndIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(@RequestParam(required = false)int serve,@RequestParam(required = false)String excludeIngredient,@RequestParam(required = false)String instruction){
        return recipeRepo.getRecipeByServeAndIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(serve,excludeIngredient,instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","serve","excludeIngredient","instruction"})
    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(@RequestParam(required = false)boolean vegetarian,@RequestParam(required = false)int serve,@RequestParam(required = false)String excludeIngredient ,@RequestParam(required = false) String instruction){
        return recipeRepo.getRecipeByVegetarianAndServeAndIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(vegetarian,serve,excludeIngredient,instruction);
    }

    @GetMapping(value = "/recipe/search" , params = {"vegetarian","serve","excludeIngredient","includeIngredient","instruction"})
    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionNotContainingIgnoreCaseAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(@RequestParam(required = false)boolean vegetarian,@RequestParam(required = false)int serve,@RequestParam(required = false)String excludeIngredient,@RequestParam(required = false)String includeIngredient ,@RequestParam(required = false) String instruction){
        return recipeRepo.getRecipeByVegetarianAndServeAndIngredients_DescriptionNotContainingIgnoreCaseAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(vegetarian,serve,excludeIngredient,includeIngredient,instruction);
    }


    @PostMapping(value = "/recipe/add")
    public Recipe saveRecipe(@RequestBody Recipe recipe) {


        return saveRecipeInternal(recipe);
    }

    private Recipe saveRecipeInternal(Recipe recipe) {
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.setRecipe(recipe);

        }
        Recipe savedRecipe = recipeRepo.save(recipe);
        if (recipe.getIngredients() != null) {

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.setRecipe(savedRecipe);
                ingredientRepo.save(ingredient);
            }

        }
        return savedRecipe;
    }


    @PutMapping(value = "/recipe/update/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable long id) {
        if (recipeRepo.findById(id).get() == null) {
            throw new ResourceNotFoundException("No Recipe");
        }
        recipe.setRecipeId(id);
        return saveRecipe(recipe);

    }

    @DeleteMapping(value = "/recipe/delete/{id}")
    public Recipe deleteRecipe(@PathVariable long id) {
        Recipe deleted = recipeRepo.findById(id).get();
        recipeRepo.deleteById(id);
        return deleted;
    }


}

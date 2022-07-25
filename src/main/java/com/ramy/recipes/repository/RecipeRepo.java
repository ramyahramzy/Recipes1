package com.ramy.recipes.repository;

import com.ramy.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {


    public List<Recipe> getRecipeByVegetarian(boolean vegetarian);
    public List<Recipe> getRecipeByServe(int serve);
    public List<Recipe> getRecipeByIngredients_DescriptionContainingIgnoreCase(String description);
    public List<Recipe> getRecipeByIngredients_DescriptionNotContainingIgnoreCase(String description);
    public List<Recipe> getRecipeByInstructionContainingIgnoreCase( String instruction);


    public List<Recipe> getRecipeByVegetarianAndServe(boolean vegetarian,int serve);
    public List<Recipe> getRecipeByVegetarianAndIngredients_DescriptionContainingIgnoreCase(boolean vegetarian,String description);
    public List<Recipe> getRecipeByVegetarianAndIngredients_DescriptionNotContainingIgnoreCase(boolean vegetarian,String description);
    public List<Recipe> getRecipeByVegetarianAndInstructionContainingIgnoreCase(boolean vegetarian, String instruction);


    public List<Recipe> getRecipeByServeAndIngredients_DescriptionContainingIgnoreCase(int serve,String description);
    public List<Recipe> getRecipeByServeAndIngredients_DescriptionNotContainingIgnoreCase(int serve,String description);
    public List<Recipe> getRecipeByServeAndInstructionContainingIgnoreCase(int serve,String instruction);


    public List<Recipe> getRecipeByIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(String description,String instruction);
    public List<Recipe> getRecipeByIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(String description,String instruction);


    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionContainingIgnoreCase(boolean vegetarian,int serve,String description);
    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionNotContainingIgnoreCase(boolean vegetarian,int serve,String description);
    public List<Recipe> getRecipeByVegetarianAndServeAndInstructionContainingIgnoreCase(boolean vegetarian,int serve,String instruction);
    public List<Recipe> getRecipeByVegetarianAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(boolean vegetarian,String description,String instruction);
    public List<Recipe> getRecipeByVegetarianAndIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(boolean vegetarian,String description,String instruction);

    public List<Recipe> getRecipeByServeAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(int serve,String description,String instruction);
    public List<Recipe> getRecipeByServeAndIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(int serve,String description,String instruction);


    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(boolean vegetarian,int serve,String description , String instruction);
    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionNotContainingIgnoreCaseAndInstructionContainingIgnoreCase(boolean vegetarian,int serve,String description , String instruction);


    public List<Recipe> getRecipeByVegetarianAndServeAndIngredients_DescriptionNotContainingIgnoreCaseAndIngredients_DescriptionContainingIgnoreCaseAndInstructionContainingIgnoreCase(boolean vegetarian,int serve,String description ,String description1, String instruction);





}

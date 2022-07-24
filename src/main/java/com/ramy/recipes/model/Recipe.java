package com.ramy.recipes.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Recipe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recipeId;

    @Column
    private String name;



    @Column
    private Integer serve;


    @Column
    @Lob
    private String instruction;

    @Column
    private boolean vegetarian;

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients;

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Integer getServe() {
        return serve;
    }

    public void setServe(Integer serve) {
        this.serve = serve;
    }


}

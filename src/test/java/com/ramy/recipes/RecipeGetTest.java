package com.ramy.recipes;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class RecipeGetTest extends RecipesApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before("testEmployee")
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testRecipe() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(get("/recipe/recipes")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;")).
                andExpect(jsonPath("$[0].recipeId").value("1"));
                

    }
}

package com.galvanize.recipeApp;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/recipes")
//    @JsonView(View.RecipeView.class)
    public Iterable<Recipe> getRecipes(){
        return this.recipeRepository.findAll();
    }


}

package com.galvanize.recipeApp;

import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public IngredientController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    public Iterable<Ingredient> getIngredients(){
        return this.ingredientRepository.findAll();
    }
}

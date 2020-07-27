package com.galvanize.recipeApp;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe body){
        return this.recipeRepository.save(body);
    }

    @DeleteMapping("/recipes/{id}")
    public String deleteRecipe(@PathVariable Long id){
        if (this.recipeRepository.findById(id).isPresent()) {
            this.recipeRepository.deleteById(id);
            return String.format("Deleted recipe with id %s",id);
        } else {
            return "Could not find that recipe to delete";
        }
    }

}

package com.galvanize.recipeApp;

import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

@RestController
public class RecipeController {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/recipes")
    public Iterable<Recipe> getRecipes(){

        return this.recipeRepository.findAll();
    }

    @GetMapping("/recipes/{id}/ingredients")
    public Object getRecipeIngredients(@PathVariable Long id){
        if (this.recipeRepository.findById(id).isPresent()) {
            return this.recipeRepository.findById(id).get().getIngredients();
        } else {
            return "No recipe found with that id";
        }
    }

    @GetMapping("/recipes/byTime/")
    public List<Recipe> getRecipeByPrepTime(@RequestParam HashMap queryString){
        Duration prepTime;
        Duration cookTime;
        String operator = (String) queryString.get("operator");

        if (queryString.get("preptime") == null) {
            prepTime = Duration.parse("PT100H");
            operator = "and";
        } else {
            prepTime = Duration.parse((CharSequence) queryString.get("preptime"));
        }
        if (queryString.get("cooktime") == null) {
            cookTime = Duration.parse("PT100H");
            operator = "and";
        } else {
            cookTime = Duration.parse((CharSequence)queryString.get("cooktime"));
        }


        if (operator == null){
            operator = "or";
        }

        System.out.println(prepTime);

        if (operator.equals("or")) {
            return this.recipeRepository.findByPreptimeLessThanOrCooktimeLessThan(prepTime, cookTime);
        } else {
            return this.recipeRepository.findByPreptimeLessThanAndCooktimeLessThan(prepTime, cookTime);
        }
    }

    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe body){
        Long newId = this.recipeRepository.save(body).getId();
        return this.recipeRepository.findById(newId).get();
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

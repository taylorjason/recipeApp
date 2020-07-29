package com.galvanize.recipeApp;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class IngredientController {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public IngredientController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    @JsonView(Views.Public.class)
    public Iterable<Ingredient> getIngredients(){
        return this.ingredientRepository.findAll();
    }

    @GetMapping("/ingredients/{id}/recipes")
    @JsonView(Views.Public.class)
    public Object getRecipesByIngredientId(@PathVariable Long id){
        Optional<Ingredient> result = this.ingredientRepository.findById(id);
        if(result.isPresent()){
            Ingredient ingredient = result.get();
            return ingredient.getRecipes();
        } else {
            return "No ingredient with that ID found";
        }
    }

    @GetMapping("/ingredients/{type}")
    public Object getByType(@PathVariable String type){
        List<Ingredient> result = this.ingredientRepository.findByTypeContaining(type);
        if(result.size() != 0){
            return result;
        } else {
            return "No ingredient with that type found";
        }
    }
    @GetMapping("/ingredients/search/")
    public Object getByName(@RequestParam HashMap queryString) {
        String name = (String) queryString.get("name");
        String type = (String) queryString.get("type");
        String operator = (String) queryString.get("operator");
        if (name == null) {
            name = "";
        }
        if (operator == null){
            operator = "or";
        }

        if (operator.equals("or")) {
            return this.ingredientRepository.findByNameLikeOrType(name, type);
        } else {
            return this.ingredientRepository.findByNameLikeAndType(name, type);
        }

    }
}

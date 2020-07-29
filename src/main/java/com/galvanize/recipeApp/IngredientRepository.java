package com.galvanize.recipeApp;

import org.springframework.data.repository.CrudRepository;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    List<Ingredient> findByTypeContaining(String type);

    List<Ingredient> findByNameContaining(String name);

    List<Ingredient> findByNameContainingOrType(String name, String type);

    List<Ingredient> findByNameOrType(String name, String type);

    List<Ingredient> findByName(String name);

    List<Ingredient> findByNameLikeOrType(String name, String type);

    List<Ingredient> findByNameLikeAndType(String name, String type);


}

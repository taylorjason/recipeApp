package com.galvanize.recipeApp;

import org.springframework.data.repository.CrudRepository;

import java.time.Duration;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findByPreptimeLessThan(Duration preptime);

    List<Recipe> findByPreptimeGreaterThan(Duration preptime);

    List<Recipe> findByPreptimeLessThanOrCooktimeLessThan(Duration prepTime, Duration cookTime);

    List<Recipe> findByPreptimeLessThanAndCooktimeLessThan(Duration prepTime, Duration cookTime);
}

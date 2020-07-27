package com.galvanize.recipeApp;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;

@Entity
@Table(name="recipe")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int servings;
    private Duration cook_time;
    private Duration prep_time;
    @ManyToMany
    @JoinTable(
            name="recipe_ingredient_join",
            joinColumns = @JoinColumn(name="recipe_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    private Set<Ingredient> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public Long getCook_time() {
        return cook_time.toMinutes();
    }

    public void setCook_time(Duration cook_time) {
        this.cook_time = cook_time;
    }

    public Long getPrep_time() {
        return prep_time.toMinutes();
    }

    public void setPrep_time(Duration prep_time) {
        this.prep_time = prep_time;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

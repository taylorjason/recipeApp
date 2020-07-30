package com.galvanize.recipeApp;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;

@Entity
@Table(name="recipe")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;
    @JsonView(Views.Public.class)
    private String title;
    @JsonView(Views.Public.class)
    private String description;
    @JsonView(Views.Public.class)
    private int servings;
    @JsonView(Views.Public.class)
    private Duration cooktime;
    @JsonView(Views.Public.class)
    private Duration preptime;
    @ManyToMany
    @JoinTable(
            name="recipe_ingredient_join",
            joinColumns = @JoinColumn(name="recipe_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    @JsonView(Views.Public.class)
    @JsonIgnoreProperties("recipes")
    private Set<Ingredient> ingredients;
    @JsonView(Views.Public.class)
    private String imgURL;
    @JsonView(Views.Public.class)
    private String recipeSteps;


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

    public Long getCooktime() {
        return cooktime.toMinutes();
    }

    public void setCooktime(Duration cooktime) {
        this.cooktime = cooktime;
    }

    public Long getPreptime() {
        return preptime.toMinutes();
    }

    public void setPreptime(Duration preptime) {
        this.preptime = preptime;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(String recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
}

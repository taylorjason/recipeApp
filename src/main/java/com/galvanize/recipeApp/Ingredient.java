package com.galvanize.recipeApp;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonView(View.RecipeView.class)
    private Long id;
    @JsonView(View.RecipeView.class)
    private String name;
    @JsonView(View.RecipeView.class)
    private String type;
    @ManyToMany
    private Set<Recipe> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}

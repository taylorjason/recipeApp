package com.galvanize.recipeApp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;

@Entity
@Table(name="shopping_item")
public class ListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;
    @OneToOne
    @JsonView(Views.listItems.class)
    private ShoppingList shoppingList;
    @OneToOne
    @JsonView(Views.Public.class)
    private Ingredient ingredient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}

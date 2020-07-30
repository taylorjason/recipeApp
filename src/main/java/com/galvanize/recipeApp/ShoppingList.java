package com.galvanize.recipeApp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shopping_list")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;
    @JsonView(Views.Public.class)
    private String title;
    @JsonView(Views.Public.class)
    private String description;
    @JsonView(Views.Public.class)
    @JsonFormat(pattern = "M/d/yy")
    private Date date;
    @JsonView(Views.Public.class)
    @OneToMany(mappedBy = "shoppingList")
    @JsonIgnoreProperties("shoppingList")
    private List<ListItem> items;

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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonIgnoreProperties("shoppingList")
    public List<ListItem> getItems() {
        return items;
    }

    public void setItems(List<ListItem> items) {
        this.items = items;
    }
}

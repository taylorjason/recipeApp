package com.galvanize.recipeApp;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShoppingListController {

    private final ShoppingListRepository listRepository;
    private final ListItemRepository listItemRepository;

    public ShoppingListController(ShoppingListRepository listRepository, ListItemRepository listItemRepository) {
        this.listRepository = listRepository;
        this.listItemRepository = listItemRepository;
    }

    @GetMapping("/lists")
    @JsonView(Views.Public.class)
    public Iterable<ShoppingList> getList(){
        return this.listRepository.findAll();
    }

    @PostMapping("/lists/add")
    @JsonView(Views.Public.class)
    public ShoppingList addList(@RequestBody ShoppingList newList){
        return this.listRepository.save(newList);
    }

    @GetMapping("/lists/{id}/items")
    @JsonView(Views.Public.class)
    public Object getListItems(@PathVariable Long id){
        Optional<ShoppingList> result = this.listRepository.findById(id);
        if (result.isPresent()){
            ShoppingList list = result.get();
            return list.getItems();
        } else {
            return "List with that ID not found";
        }

    }

    @PostMapping("/items")
    public Object addListItems(@RequestBody ListItem item){
        return this.listItemRepository.save(item);
    }

    @GetMapping("/items")
    @JsonView(Views.listItems.class)
    public Object getItems(){
        return this.listItemRepository.findAll();
    }

}

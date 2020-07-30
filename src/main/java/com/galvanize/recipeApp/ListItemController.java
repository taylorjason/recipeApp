package com.galvanize.recipeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListItemController {
    private final ListItemRepository itemRepository;

    public ListItemController(ListItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

}

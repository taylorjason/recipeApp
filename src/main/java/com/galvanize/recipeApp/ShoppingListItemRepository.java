package com.galvanize.recipeApp;

import org.springframework.data.repository.CrudRepository;

public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Long> {
}

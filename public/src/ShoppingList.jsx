import React from 'react';
import { useState, useEffect } from 'react';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import RestaurantIcon from '@material-ui/icons/Restaurant';
import KitchenIcon from '@material-ui/icons/Kitchen';
import IconButton from '@material-ui/core/IconButton';
import AddCircleIcon from '@material-ui/icons/AddCircle';

export default function ShoppingList({ ingredients }) {
  return ingredients === undefined ? null : (
    <List>
      {ingredients.map((ingredient, index) => (
        <ListItem
          button
          key={ingredient.id}
          //   onClick={(e) => handleClick(recipe, e)}
        >
          <ListItemIcon>
            {index % 2 === 0 ? <RestaurantIcon /> : <KitchenIcon />}
          </ListItemIcon>
          <ListItemText primary={ingredient.ingredient.name} />
          <IconButton edge="end" aria-label="delete">
            <AddCircleIcon />
          </IconButton>
        </ListItem>
      ))}
    </List>
  );
}

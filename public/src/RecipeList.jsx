import React from 'react';
import { useState, useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
// import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import RestaurantMenuIcon from '@material-ui/icons/RestaurantMenu';
import RestaurantIcon from '@material-ui/icons/Restaurant';
import { Grid } from '@material-ui/core';
import RecipeCard from './RecipeCard';
// import recipeMakerList from './constants';
import IngredientList from './IngredientList';
import ShoppingList from './ShoppingList';

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex'
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0
  },
  drawerPaper: {
    width: drawerWidth
  },
  drawerContainer: {
    overflow: 'auto'
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3)
  }
}));

export default function ClippedDrawer() {
  const [recipes, setRecipes] = useState([]);
  const [recipe, setRecipe] = useState({});
  const [listId, setListId] = useState(1);
  const [list, setList] = useState([]);
  const [recipeId, setRecipeId] = useState(1);

  useEffect(() => {
    fetch('http://localhost:8080/recipes')
      .then((res) => res.json())
      .then((data) => {
        setRecipe(data[0]);
        setRecipes(data);
      });
    //   return () => {
    //       cleanup
    //   }
  }, []);

  useEffect(() => {
    fetch(`http://localhost:8080/recipes/${recipeId}`)
      .then((res) => res.json())
      .then((data) => {
        setRecipe(data);
      });
  }, [recipeId]);

  useEffect(() => {
    fetch(`http://localhost:8080/lists/${listId}/items`)
      .then((res) => res.json())
      .then((data) => {
        setList(data);
      });
  }, [listId]);

  const classes = useStyles();

  let handleClick = (toSelect, e) => {
    e.persist();
    // setRecipe(toSelect);
    setRecipeId(toSelect.id);
  };

  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <Typography variant="h6" noWrap>
            Family Recipe App
          </Typography>
        </Toolbar>
      </AppBar>
      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{
          paper: classes.drawerPaper
        }}
      >
        <Toolbar />
        <div className={classes.drawerContainer}>
          <List>
            {recipes.map((recipe, index) => (
              <ListItem
                button
                key={recipe.id}
                onClick={(e) => handleClick(recipe, e)}
              >
                <ListItemIcon>
                  {index % 2 === 0 ? (
                    <RestaurantIcon />
                  ) : (
                    <RestaurantMenuIcon />
                  )}
                </ListItemIcon>
                <ListItemText primary={recipe.title} />
              </ListItem>
            ))}
          </List>
        </div>
      </Drawer>
      <main className={classes.content}>
        <Toolbar />
        <Grid item container spacing={2}>
          <Grid item xs={12} sm={9}>
            <RecipeCard {...recipe} />
          </Grid>
          <Grid item container xs={false} sm={3}>
            <Grid item xs={12}>
              <Typography>Ingredient List</Typography>
              <IngredientList ingredients={recipe.ingredients} />
            </Grid>
            <Grid item xs={12}>
              <Typography>Shopping List</Typography>
              <ShoppingList ingredients={list} />
            </Grid>
          </Grid>
        </Grid>
      </main>
    </div>
  );
}

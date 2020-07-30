import React from 'react';
import RecipeCard from './RecipeCard';
import { Grid } from '@material-ui/core';
import recipeMakerList from './constants';

const Content = () => {
  return (
    <Grid container spacing={2}>
      <RecipeCard {...recipeMakerList[0]} />
    </Grid>
  );
};

export default Content;

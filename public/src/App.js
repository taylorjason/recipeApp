import React from 'react';

import { createMuiTheme } from '@material-ui/core/styles';
import { ThemeProvider } from '@material-ui/styles';

import RecipeList from './RecipeList';

const darkTheme = createMuiTheme({
  // palette: {
  //   type: 'dark'
  // }
});

const App = () => {
  return (
    <ThemeProvider theme={darkTheme}>
      <RecipeList />
    </ThemeProvider>
  );
};

export default App;

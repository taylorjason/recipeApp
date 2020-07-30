import React from 'react';
import { AppBar, Toolbar, Typography } from '@material-ui/core';
import KitchenIcon from '@material-ui/icons/Kitchen';
import { makeStyles } from '@material-ui/styles';
import Box from '@material-ui/core/Box';

const useStyles = makeStyles(() => ({
  typographyStyles: {
    flex: 1
  }
}));

const Header = () => {
  const classes = useStyles();
  return (
    <Box mb={2}>
      <AppBar position="static" mb={2}>
        <Toolbar>
          <Typography className={classes.typographyStyles}>
            Family Recipe App
          </Typography>
          <KitchenIcon />
        </Toolbar>
      </AppBar>
    </Box>
  );
};

export default Header;

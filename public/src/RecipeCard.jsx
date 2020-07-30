import React from 'react';
// import { makeStyles } from "@material-ui/core/styles";
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import ShareIcon from '@material-ui/icons/Share';
import { IconButton, CardMedia } from '@material-ui/core';
import CircularProgress from '@material-ui/core/CircularProgress';

const RecipeCard = (props) => {
  const {
    title,
    description,
    imgURL,
    recipe_steps,
    servings,
    preptime,
    cooktime
  } = props;
  let servingText = servings === undefined ? '' : 'Serves: ' + servings;
  return (
    <Card>
      <CardHeader
        action={
          <IconButton aria-label="settings">
            <ShareIcon />
          </IconButton>
        }
        title={title}
        subheader={servingText}
      />
      {imgURL ? (
        <CardMedia style={{ height: '350px' }} image={imgURL} />
      ) : (
        <CircularProgress />
      )}
      <CardContent>
        <Typography variant="body2" component="p">
          {description}
        </Typography>
      </CardContent>
      <CardActions>
        <Button size="small">BUY NOW</Button>
        <Button size="small">OFFER</Button>
      </CardActions>
    </Card>
  );
};

export default RecipeCard;

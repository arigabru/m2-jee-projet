import { Typography } from "@mui/material";
import React from "react";
import { AppBar } from "@mui/material";
import { Grid } from "@mui/material";
import { Box } from "@mui/material";
import { Button } from "@mui/material";
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import { useNavigate } from "react-router-dom";
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { Icon } from '@mui/material';
import { IconButton } from '@mui/material';
import { axiosInterceptor } from '../actions/axiosInterceptor';
import { getCard } from '../actions/warActions';

export default function WarPage() {

    const getRandCard = () => {
        console.log(getCard().data)
    }

    document.body.style.backgroundColor = "#d1deeb"
    return(
        <>
            <AppBar position="static" color="warning" sx={{backgroundColor:"#8cb9e6"}}>
                <Grid container spacing={20} direction="row"  alignItems="Center">
                    <Grid item xs={'auto'} md={4}>
                        <Typography variant="h4">Games</Typography>
                    </Grid>
                </Grid>
            </AppBar>
            
            <Button onClick={() =>{getRandCard()}}>
                Jouer 
            </Button>
        </>
    );


}
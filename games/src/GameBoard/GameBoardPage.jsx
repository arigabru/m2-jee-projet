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
import PFC from './img/PFC.jpg'
import war from './img/war.jpg'
import blackJack from './img/Blackjack.jpg'
import { useNavigate } from "react-router-dom";
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { Icon } from '@mui/material';
import { IconButton } from '@mui/material';


export default function GameBoardPage() {

    const navigate = useNavigate();
    const goToPFC = () => {
        navigate('/pfc')
    }

    const goToWar = () => {
        navigate('/war')
    }

    document.body.style.backgroundColor = "#d1deeb"
    return(
        <>
            <AppBar position="static" color="warning" sx={{backgroundColor:"#8cb9e6"}}>
                <Grid container spacing={20} direction="row"  alignItems="Center">
                    <Grid item xs={'auto'} md={2}>
                        <Typography variant="h4">Games</Typography>
                    </Grid>
                    <Grid item xs={'auto'} md={8}>
                        
                    </Grid>
                    <Grid item xs={'auto'} md={2}>
                        <IconButton color="inherit" > 
                            <AccountCircleIcon 
                            fontSize="large"
                            />
                        </IconButton>
                    </Grid>
                </Grid>
            </AppBar>

            <Box container display="flex"
                justifyContent="center"
                alignItems="center"
                minHeight="80vh"
            >

                <Grid container
                    direction="row"
                    alignItems="center"
                    justifyContent="center"
                    spacing={10}
                    xs={12}
                >
                    <Grid item>
                        <Card sx={{ maxWidth: 345 }} elevation={6}>
                        <CardMedia
                            component="img"
                            height="140"
                            image={PFC}
                            alt="pierre feuille ciseaux"
                        />
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                            Pierre-Feuille-Ciseaux
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                            Pierre-Feuille-Ciseaux est un jeu dont les joueurs choisissent simultanément un des trois coups possibles
                            </Typography>
                        </CardContent>
                        <CardActions>
                            <Button onClick={() =>{goToPFC()}}>Jouer</Button>
                        </CardActions>
                        </Card>
                    </Grid>
                    
                    <Grid item>
                        <Card sx={{ maxWidth: 345 }} elevation={6}>
                        <CardMedia
                            component="img"
                            height="140"
                            image={war}
                            alt="bataille"
                        />
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                            Bataille
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                            La bataille est un jeu de cartes dans lequel deux adversaires s'affrontent et jouent la victoire
                            sous la condition du hasard
                            </Typography>
                        </CardContent>
                        <CardActions>
                            <Button onClick={() =>{goToWar()}}>Jouer</Button>
                        </CardActions>
                        </Card>

                    </Grid>

                    <Grid item>
                        <Card sx={{ maxWidth: 345 }} elevation={6}>
                        <CardMedia
                            component="img"
                            height="140"
                            image={blackJack}
                            alt="blackJack"
                        />
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                            BlackJack
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                            Le blackJack est un jeu de cartes dont le but est de battre le croupier sans dépasser un
                            score de 21 
                            </Typography>
                        </CardContent>
                        <CardActions>
                            <Button>Jouer</Button>
                        </CardActions>
                        </Card>

                    </Grid>
                </Grid>
                
            </Box>

        </>

    );

}
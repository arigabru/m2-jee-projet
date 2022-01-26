import { Typography } from "@mui/material";
import React from "react";
import { AppBar } from "@mui/material";
import { Grid } from "@mui/material";
import { Box } from "@mui/material";
import { Button } from "@mui/material";
import { getCard } from '../actions/warActions';
import { startRound } from "../actions/warActions";
import { useState } from "react";
import Card from "react-free-playing-cards/lib/TcN"
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import TextField from '@mui/material/TextField';


export default function WarPage() {

    const [playerCard, setPlayerCard] = useState("Ts")
    const [botCard, setBotCard] = useState("Ts")
    const [isBacked, setBack] = useState(true)
    const [roundWinner, setRoundWinner] = useState(null)
    const [roundWon, setRoundWon] = useState(0)
    const [roundLost, setRoundLost] = useState(0)
    const [nbRounds, setnbRounds] = useState(5)
    const [tempRound, setTempRound] = useState(0)
    const [currentRound, setCurrentRound] = useState(0)
    const [dialogOpen, setOpen] = useState(true)
    const [dialogEndGameOpen, setDialogEndGameOpen] = useState(false)
    const [winner, setWinner] = useState(null)
    const [gameButtonLabel, setGameButtonLabel] = useState("Jouer")
    

    const handleClose = () => {
        setOpen(false);
        setDialogEndGameOpen(false)
        
    };

    const restartGame = () => {
        handleClose()
        startRound(tempRound)
        setnbRounds(tempRound)
        setRoundLost(0)
        setRoundWon(0)
        setCurrentRound(0)
    }

    const fromEndToRestart = () => {
        handleClose()
        setOpen(true)
        
    }

    const getRandCard = () => {
        
        setBack(false)
        getCard().then((response) => {
            setPlayerCard(response.carteJoueur)
            setBotCard(response.carteBot) 
            setnbRounds(response.nbRound)
            setCurrentRound(currentRound+1)
            setRoundWon(response.scoreJoueur)
            setRoundLost(response.scoreBot)

            if(response.roundActuel > response.nbRound)
            {
                if(response.scoreJoueur > response.scoreBot){
                    setWinner(" Joueur ")
                }
                if(response.scoreJoueur < response.scoreBot){
                    setWinner(" Ordinateur ")
                }
                if(response.scoreJoueur === response.scoreBot){
                    setWinner(" Egalité ")
                }
                setGameButtonLabel("Jouer")

                setDialogEndGameOpen(true)
            }

        })
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
            
            <Box sx={{ pt: 10 }} >
            <Grid container>
                    <Grid item md={3}>
                    </Grid>    
                    <Grid item md={3}>
                        <Typography variant="h5"> Joueur </Typography>
                    </Grid>
                    <Grid item md={3}>
                        <Typography variant="h5"> Ordinateur </Typography>
                    </Grid> 
                    <Grid item md={3}>
                    </Grid>
                </Grid>

                <Grid container>
                    <Grid item md={3}>
                    </Grid>    
                    <Grid item md={3}>
                        <Card card={playerCard} height="200px" back={isBacked}></Card>
                    </Grid>
                    <Grid item md={3}>
                        <Card card={botCard} height="200px" back={isBacked}></Card>
                    </Grid> 
                    <Grid item md={3}>
                    </Grid>
                </Grid>

                <Grid container>
                    <Grid item md={3}>
                    </Grid>    
                    <Grid item md={6}>
                        <Button variant="contained" onClick={() =>{getRandCard()}}>
                            {gameButtonLabel} 
                        </Button>                    
                    </Grid> 
                    <Grid item md={3}>
                    </Grid>
                </Grid>

                <Grid container sx={{pt:5}}>
                    <Grid item md={3}>
                    </Grid>    
                    <Grid item md={6}>
                        <Typography variant="h4"> Gagnant de la manche : {roundWinner}</Typography>                 
                    </Grid> 
                    <Grid item md={3}>
                    </Grid>
                </Grid>

                <Grid container sx={{pt:5}}>
                    <Grid item md={3}>
                    </Grid>    
                    <Grid item md={6}>
                        <Typography variant="h6"> Nombre de manches remportées par le joueur : {roundWon}</Typography>   
                        <Typography variant="h6"> Nombre de manches remportées par l'ordinateur : {roundLost}</Typography>                
                    </Grid> 
                    <Grid item md={3}>
                    </Grid>
                </Grid>

                <Grid container sx={{pt:5}}>
                    <Grid item md={3}>
                    </Grid>    
                    <Grid item md={6}>
                        <Typography variant="h6"> Manche : {currentRound}/{nbRounds}</Typography>                 
                    </Grid> 
                    <Grid item md={3}>
                    </Grid>
                </Grid>

                <Grid container>
                    <Grid item md={3}>
                    </Grid>    
                    <Grid item md={6}>
                        <Button variant="contained" onClick={() =>{setOpen(true)}}>
                            Relancer
                        </Button>                    
                    </Grid> 
                    <Grid item md={3}>
                    </Grid>
                </Grid>
            </Box>

            <Dialog open={dialogOpen} >
                <DialogTitle>Rejouer</DialogTitle>
                <DialogContent>
                <DialogContentText>
                    Entrez le nombre de manches que vous souhaitez jouer
                </DialogContentText>
                <TextField
                    autoFocus
                    margin="dense"
                    id="nbRounds"
                    label="Nombre de manches"
                    type="number"
                    fullWidth
                    variant="standard"
                    onChange={(event) => setTempRound(event.target.value)} 
                />
                
                </DialogContent>
                <DialogActions>
                <Button variant="contained" onClick={() =>{restartGame()}}>
                    Jouer
                </Button>
                </DialogActions>
            </Dialog>

            <Dialog open={dialogEndGameOpen} >
                <DialogTitle>Fin de partie</DialogTitle>
                <DialogContent>
                <DialogContentText>
                    Le gagnant est : {winner}
                </DialogContentText>                
                </DialogContent>
                <DialogActions>
                <Button variant="contained" onClick={() =>{fromEndToRestart()}}>
                    Relancer
                </Button>
                </DialogActions>
            </Dialog>
        </>
    );


}
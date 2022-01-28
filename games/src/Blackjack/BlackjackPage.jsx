import { Typography } from "@mui/material";
import React from "react";
import { AppBar } from "@mui/material";
import { Grid } from "@mui/material";
import { Box } from "@mui/material";
import { Button } from "@mui/material";
import { getCard } from '../actions/blackjackActions';
import { startRound } from "../actions/blackjackActions";
import { stopDraw } from "../actions/blackjackActions";
import { useState } from "react";
import Card from "react-free-playing-cards/lib/TcN"
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import TextField from '@mui/material/TextField';
import { useNavigate } from "react-router-dom";
import { nextRound } from "../actions/blackjackActions";

export default function BlackjackPage() {

    const [playerCard, setPlayerCard] = useState("Ts")
    const [botCard, setBotCard] = useState("Ts")
    const [isBacked, setBack] = useState(true)
    const [roundWinner, setRoundWinner] = useState(null)
    const [roundWon, setRoundWon] = useState(0)
    const [roundLost, setRoundLost] = useState(0)
    const [nbRounds, setnbRounds] = useState(5)
    const [tempRound, setTempRound] = useState(1)
    const [currentRound, setCurrentRound] = useState(1)
    const [dialogOpen, setOpen] = useState(true)
    const [dialogEndGameOpen, setDialogEndGameOpen] = useState(false)
    const [winner, setWinner] = useState(null)
    const [gameButtonLabel, setGameButtonLabel] = useState("Jouer")
    const [scoreJoueur, setScoreJoueur] = useState(0)
    const [scoreBot, setScoreBot] = useState(0)
    const [mainJoueur, setMainJoueur]=useState([])
    const [mainBot, setMainBot]=useState([])
    const [tirer, setTirer] = useState(false)
    const [scoreMancheJoueur, setScoreMancheJoueur] = useState(0)
    const [scoreMancheBot, setScoreMancheBot] = useState(0)
    

    const navigate = useNavigate();
    const goToMenu = () => {
        navigate('/gameBoard')
    }

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
        setCurrentRound(1)
        setTirer(false)
        setMainJoueur=[]
        setMainBot=[]
        setScoreBot(0)
        setScoreJoueur(0)
    }

    const nextRoundInGame = () => {
        setTirer(false)
        
    }

    const fromEndToRestart = () => {
        handleClose()
        setOpen(true)
            
    }

    const stopDrawCards = () => {
        stopDraw().then((response) => {
            console.log(response)
            setMainBot(response.deckBot)
            setTirer(true)
            setScoreBot(response.sommeBot)
            nextRound().then((response) => {
                if(response.roundActuel <= nbRounds){
                    setCurrentRound(response.roundActuel)
                    setRoundWon(response.scoreJoueur)
                    setRoundLost(response.scoreBot)
                    nextRoundInGame()
                }  
            })
        })
    }

    const getRandCard = () => {
        
        setBack(false)
        getCard().then((response) => {

            
            setScoreJoueur(response.sommeJoueur)
            setMainJoueur(response.deckJoueur)
            console.log(mainJoueur)
            console.log(response)
            setScoreBot(0)
            if(response.sommeJoueur > 21){
                stopDraw().then((response) => {
                    console.log(response)
                    setMainBot(response.deckBot)
                    setTirer(true)
                    setScoreBot(response.sommeBot)
                    nextRound().then((response) => {
                        if(response.roundActuel <= nbRounds){
                            setCurrentRound(response.roundActuel)
                            setRoundWon(response.scoreJoueur)
                            setRoundLost(response.scoreBot)
                            nextRoundInGame()
                        }  
                    })
                })
            }

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
    return (
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
                        <Typography variant="h5" sx={{mt:2}}> Score : {scoreJoueur} </Typography>
                    </Grid>
                    <Grid item md={3}>
                        {mainJoueur.map((carte, i) => (
                                <Card card={carte} height="100px" back={isBacked}></Card>
                        ))}
                        
                    </Grid>
                    <Grid item md={3}>
                    </Grid>
                </Grid>

                <Grid container>
                    <Grid item md={3}>
                    </Grid>    
                    <Grid item md={3}>
                        <Typography variant="h5"> Ordinateur </Typography>
                        <Typography variant="h5" sx={{mt:2}}> Score : {scoreBot} </Typography>
                    </Grid> 
                    <Grid item md={3}>
                        {mainBot.map((carte, i) => (
                                <Card card={carte} height="100px" back={isBacked}></Card>
                        ))}
                        
                    </Grid> 
                    <Grid item md={3}>
                    </Grid>
                </Grid>

                <Grid container>
                    <Grid item md={3}>
                    </Grid>    
                    <Grid item md={6}>
                        <Button variant="contained" disabled={tirer} onClick={() =>{getRandCard()}}>
                            Tirer
                        </Button> 
                        <Button variant="contained" disabled={tirer} onClick={() =>{stopDrawCards()}}>
                            Stop
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
            <DialogTitle>Manches</DialogTitle>
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
                <Button variant="contained" onClick={() =>{goToMenu()}}>
                    Menu
                </Button>
                <Button variant="contained" onClick={() =>{fromEndToRestart()}}>
                    Relancer
                </Button>
                </DialogActions>
            </Dialog>            
        </>

        
    );

}
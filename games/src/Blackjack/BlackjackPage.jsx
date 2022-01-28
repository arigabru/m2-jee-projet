import { Typography } from "@mui/material";
import React from "react";
import { AppBar } from "@mui/material";
import { Grid } from "@mui/material";
import { Box } from "@mui/material";
import { Button } from "@mui/material";
import { getCard } from '../actions/blackjackActions';
import { startRound } from "../actions/blackjackActions";
import { useState } from "react";
import Card from "react-free-playing-cards/lib/TcN"
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import TextField from '@mui/material/TextField';
import { useNavigate } from "react-router-dom";

export default function BlackjackPage() {

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
        setCurrentRound(0)
    }

    const fromEndToRestart = () => {
        handleClose()
        setOpen(true)
        
    }

    const getRandCard = () => {
        
        setBack(false)
        getCard().then((response) => {

            /*
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
                */
        })
    }
    return (
        <>
            <AppBar position="static" color="warning" sx={{backgroundColor:"#8cb9e6"}}>
                <Grid container spacing={20} direction="row"  alignItems="Center">
                    <Grid item xs={'auto'} md={4}>
                        <Typography variant="h4">Games</Typography>
                    </Grid>
                </Grid>
            </AppBar>

            <Button onClick={() =>{getRandCard()}}> Tirer </Button>
        </>
    );

}
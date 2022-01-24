import React, { Component } from "react";
import { AppBar } from "@mui/material";
import { Typography } from "@mui/material";
import { Box } from "@mui/system";
import { Grid } from "@mui/material";
import { Button } from "@mui/material";
import { Toolbar } from '@mui/material';
import { Card } from '@mui/material';
import { useState, useEffect } from 'react';
import CardMedia from '@mui/material/CardMedia';
import rock from './img/rockHand.png'
import paper from './img/paperHand.png'
import scissors from './img/scissorsHand.png'


const RPS = () => {

	const [userChoice, setuserChoice] = useState(null)
	const [AIChoice, setAIChoice] = useState(null)
	const coups = ['pierre', 'papier', 'ciseaux']
	const [result , setResult] = useState(null)

	const ordi = () => {
		const choice = coups[Math.floor(Math.random() * coups.length)]
		setAIChoice(choice)
		
	}

	useEffect(() => {
		{
			switch (userChoice + AIChoice) {
				case 'ciseauxpapier':
				case 'pierreciseaux':
				case 'papierpierre':
					setResult('Victoire')
					break
				case 'papierciseaux':
				case 'ciseauxpierre':
				case 'pierrepapier':
					setResult('Defaite')
					break
				case 'papierpapier':
				case 'pierrepierre':
				case 'ciseauxciseaux':
					setResult('Egalite')
					break
			}
		}
	}, [AIChoice, userChoice])

	const handleClick = (value) => {
		setuserChoice(value)
		ordi()
	}

	return (
		<>
			<Box sx={{ flexgrow: 1}}>
				<AppBar position="static" color="warning" sx={{backgroundColor:"#8cb9e6"}}>
					<Grid container spacing={20} direction="row"  alignItems="Center">
						<Grid item xs={'auto'} md={4}>
							<Typography variant="h4">Games</Typography>
						</Grid>
					</Grid>
				</AppBar>
			</Box>

			<Grid container spacing={1} sx={{
				m:8
			}}>
				<Grid item xs={2}>
					<Card
					hoverable sx={{
						maxWidth: 275,
						minHeight: 300,
						justify: 'center',
						alignContent: 'center',
						alignItems: 'center'
					}}
					>
						<CardMedia
							component="img"
							image={rock}
							title="Rock"
						/>
						<Button onClick={() => handleClick('pierre')} variant="contained"> Jouer </Button>
					</Card>
				</Grid>

				<Grid item xs={2}>
					<Card
						hoverable sx={{
							maxWidth: 275,
							minHeight: 300,
							justify: 'center',
							alignContent: 'center',
							alignItems: 'center'
						}}
						>
							<CardMedia
							component="img"
							image={paper}
							title="Rock"
						/>
						<Button onClick={() => handleClick('papier')} variant="contained"> Jouer </Button>
					</Card>
				</Grid>

				<Grid item xs={2}>
					<Card
					hoverable sx={{
						maxWidth: 275,
						minHeight: 300,
						justify: 'center',
						alignContent: 'center',
						alignItems: 'center'
					}}
					>
						<CardMedia
							component="img"
							image={scissors}
							title="scissors"
						/>
						<Button onClick={() => handleClick('ciseaux')} variant="contained"> Jouer </Button>
					</Card>
				</Grid>
				<Grid item xs={4}>
					<h2> Vous avez choisi : {userChoice} </h2>
					<h2> L'ordinateur a choisi : {AIChoice} { } </h2>
					<h1> {result} </h1> 
				</Grid>
			</Grid>
		</>
	);
}

export default RPS; 
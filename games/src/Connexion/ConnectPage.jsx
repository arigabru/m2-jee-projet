import { TextField, Typography } from "@mui/material";
import React from "react";
import { AppBar } from "@mui/material";
import { Grid } from "@mui/material";
import { Box } from "@mui/material";
import { Paper } from "@mui/material";
import { Divider } from "@mui/material";
import { Button } from "@mui/material";
import { useForm } from "react-hook-form";
import { Controller } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { connect } from "../actions/connectActions";
import { getAdmin } from "../actions/connectActions";
import { useState } from "react";

export default function ConnectPage() {

    //const [token, setToken] = useState(null)
    var token = null
    var pseudo = null
    var mail = null

    const {register, handleSubmit, control} = useForm()
    const onSubmit = (data) => {
        sessionStorage.removeItem('mail')
        sessionStorage.removeItem('token')
        sessionStorage.removeItem('pseudo')
        connect(data.email, data.mdp).then((response) => {
            token = response.jwt
            pseudo = response.pseudo
            mail = response.email
            sessionStorage.setItem('token', token)
            sessionStorage.setItem('pseudo', pseudo)
            sessionStorage.setItem('mail', mail)
            console.log(mail)
            console.log(sessionStorage.getItem('token'))
            goToBoardGame()
        })


    } 

    const navigate = useNavigate();
    const goToBoardGame = () => {
        console.log(sessionStorage.getItem('token'))
        if(sessionStorage.getItem('token') === null){
            alert('Identifiants incorrects')
            sessionStorage.removeItem('token')
        }
        else{
            navigate('/gameBoard')
        }
    }
    const goToInscription = () => {
            navigate('/inscription')
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

            <Box sx={{ pt: 20 }} >
                <Grid container alignItems="Center" justifyContent="center">
                    <Grid item md={2}>
                    </Grid>
                    <Grid item md={8}>
                        <Grid container alignItems="Center" justifyContent="center">
                            <Paper elevation={4}>

                                <Box sx={{ pt: 4 , pl: 4, pb: 2, pr: 4 }}>
                                    <form>
                                        <Grid item md={12} sx={{ pt: 2 , pl: 4, pr: 4 }}>
                                            <Controller
                                                name={"email"}
                                                control={control}
                                                render={({ field: { onChange, value } }) => (
                                                    <TextField
                                                    onChange={onChange}
                                                    value={value}
                                                    placeholder="adresse e-mail"
                                                    required
                                                    {...register}
                                                    id="mail"
                                                    name="email"
                                                    >
                                                    </TextField> 
                                                )}
                                            />
                                        </Grid>
                                        <Grid item md={12} sx={{ pt: 2 , pl: 4, pb: 2, pr: 4 }}>
                                        <Controller
                                                name={"mdp"}
                                                control={control}
                                                render={({ field: { onChange, value } }) => (
                                                    <TextField
                                                    onChange={onChange}
                                                    value={value}
                                                    placeholder="mot de passe"
                                                    required
                                                    {...register}
                                                    id="mdp"
                                                    name="mdp"
                                                    type="password"
                                                    >
                                                    </TextField> 
                                                )}
                                            />
                                        </Grid>
                                        <Divider></Divider>
                                        <Grid container  alignItems="Center">
                                            <Button variant="Contained" sx={{ mt: 2, ml:2}} 
                                            style={{
                                            backgroundColor: "#8cb9e6",
                                            color:"white",
                                            borderRadius: 10,
                                            padding: "5px 10px",
                                            }}
                                            onClick={handleSubmit(onSubmit)}>
                                                Connexion
                                            </Button>
                                            <Button variant="Contained" sx={{ mt: 2, pr:2, ml:4}}
                                            style={{
                                            backgroundColor: "#8cb9e6",
                                            color:"white",
                                            borderRadius: 10,
                                            padding: "5px 10px",
                                            }}
                                            onClick={() =>{goToInscription()}}
                                            >
                                                Inscritpion
                                            </Button>
                                        </Grid>
                                    </form>
                                </Box>

                            </Paper>
                        </Grid>
                    </Grid>
                    <Grid item md={2}>
                    </Grid>
                </Grid>
            </Box>

        </>
    );
}

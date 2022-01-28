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
import { useState } from "react";
import { inscritpion } from "../actions/inscriptionActions";

export default function InscriptionPage() {

    const {register, handleSubmit, control} = useForm()
    //const [pseudo, setPseudo] = useState(null)
    //const [password, setPassword] = useState(null)
    //const [email, setEmail] = useState(null)

    var email, pseudo, password

    const onSubmit = (data) => {

        pseudo = data.pseudo
        password = data.mdp
        email = data.email
        inscritpion(pseudo, password, email)

    }

    const navigate = useNavigate();
    const goToConnect = () => {
        navigate('/')
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
                <Grid container alignItems="Center" justifyContent="center">
                    <Grid item md={2}>
                    </Grid>
                    <Grid item md={8}>
                        <Grid container alignItems="Center" justifyContent="center">
                            <Paper elevation={4}>

                                <Box sx={{ pt: 4 , pl: 4, pb: 2, pr: 4 }}>
                                <Grid item md={12} sx={{ pt: 2 , pl: 4, pr: 4 }}>
                                        <Typography variant="h5">
                                            Pas encore inscrit?
                                        </Typography>
                                        </Grid>
                                    <form>
                                    <Grid item md={12} sx={{ pt: 2 , pl: 4, pr: 4 }}>
                                        <Controller
                                            name={"pseudo"}
                                            control={control}
                                            render={({ field: { onChange, value } }) => (
                                                <TextField
                                                onChange={onChange}
                                                value={value}
                                                placeholder="Pseudo"
                                                required
                                                {...register}
                                                id="pseudo"
                                                name="pseudo"
                                                >
                                                </TextField> 
                                            )}
                                        />
                                        </Grid>
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
                                            <Button variant="Contained" sx={{ mt: 2, ml:4}} 
                                            style={{
                                            backgroundColor: "#8cb9e6",
                                            color:"white",
                                            borderRadius: 10,
                                            padding: "5px 10px",
                                            }}
                                            onClick={handleSubmit(onSubmit)}>
                                                S'inscrire
                                            </Button>
                                            
                                        </Grid>
                                    </form>

                                </Box>
                            </Paper>
                            <Box sx={{mt:5}}>
                                <Grid Container>
                                    <Grid item>
                                        <Paper elevation={4}>
                                            <Grid item md={12} sx={{ pt: 2 , pl: 4, pr: 4 }}>
                                                <Typography variant="h5">
                                                    Le mot de passe doit respecter les règles suivantes :
                                                </Typography>
                                            </Grid>
                                            <Grid item md={12} sx={{ pt: 2 , pl: 4, pr: 4 }}>
                                                <Typography variant="h5">
                                                    8 caractères minimum
                                                </Typography>
                                                <Typography variant="h5">
                                                    Une majuscule
                                                </Typography>
                                                <Typography variant="h5">
                                                    Un chiffre
                                                </Typography>
                                            </Grid>
                                        </Paper>
                                    </Grid>
                                </Grid>
                            </Box>
                        </Grid>
                    </Grid>
                    <Grid item md={2}>
                    </Grid>
                </Grid>
            </Box>

        </>

    );

}
import React, { Component } from "react";
import { AppBar } from "@mui/material";
import { Typography } from "@mui/material";
import { Box } from "@mui/system";
import { Grid } from "@mui/material";
import { Button } from "@mui/material";
import { Toolbar } from '@mui/material';
import { useState, useEffect } from 'react';
import { Paper } from "@mui/material";
import { Divider } from "@mui/material";
import { getUsers } from "../actions/profileActions";
import { deleteUser } from "../actions/profileActions";
import useSWR from "swr";

export default function ProfilePage () {

    const [show, setShow] = useState(false);

    const { data : users } = useSWR('users_', () =>
        getUsers()
    )

    const deleteUserInPage = (mail) => {
        deleteUser(mail)
    }

    document.body.style.backgroundColor = "#d1deeb"
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

            <Box sx={{mt:8}}>
                <Grid container
                    direction="column"
                    alignItems="center"
                    justifyContent="center"
                    xs={12}>
                    <Paper >
                        <Grid item sx={{}}>
                            <Typography sx={{m:2, p:2}}>Détail du profil</Typography>
                        </Grid>
                        <Divider sx={{ml:2, mr:2}}></Divider>
                        <Grid item sx={{}}>
                            <Typography sx={{m:2, p:2}}>Pseudo : {sessionStorage.getItem('pseudo')}</Typography>
                        </Grid>
                        <Grid item sx={{}}>
                            <Typography sx={{m:2}}>Mail : {sessionStorage.getItem('mail')}</Typography>
                            <Typography sx={{m:2}}>Admin : {sessionStorage.getItem('isAdmin')}</Typography>
                        </Grid>
                    </Paper>
                    <Paper sx={{mt:5}}>
                        <Grid item sx={{}}>
                            <Typography sx={{m:2, p:2}}>Liste des utilisateurs</Typography>
                        </Grid>
                        <Divider sx={{ml:2, mr:2}}></Divider>
                        <Grid item >
                        {users.map((user,i) =>
                                <div>
                                    <Grid container xs={12}>
                                        <Grid item md={6}>
                                            <Typography sx={{m:2}}>{user.pseudo }</Typography>
                                        </Grid>
                                        <Grid item md={6} sx={{mt:1, pr:4}}>
                                            <Button onClick={() =>{deleteUserInPage(user.email)}}>Supprimer</Button>
                                        </Grid>
                                    </Grid>
                                </div>
                            )}
                            
                        </Grid>
                    </Paper>
                </Grid>
            </Box>
        </>
    );
}
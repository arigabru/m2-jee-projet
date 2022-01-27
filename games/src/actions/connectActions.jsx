import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";

export function getCard() {
    return axiosInterceptor.get("/bataille/tirer").then((response) => response.data);
}


export function connect(email, password) {
    return axios
        .post('http://localhost:6237/authenticate' , { 
            email:email,
            password:password
        })
        .then((response) => response.data)
        .catch(function (error) {
            console.log(error);
        });
}
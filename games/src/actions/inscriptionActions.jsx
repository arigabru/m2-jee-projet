import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";

export function getCard() {
    return axiosInterceptor.get("/bataille/tirer").then((response) => response.data);
}

export function inscritpion(pseudo, password, email) {
    return axios
        .post('http://localhost:6237/api/newuser', { 
            "pseudo":pseudo,
            "password":password,
            "email":email
        })
        .then((response) => console.log(response.data))
}
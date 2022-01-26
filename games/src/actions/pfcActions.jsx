import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";

export function jouer(signe) {
    return axios
        .post('http://localhost:8080/pfc/jouer?signe=' + signe, { 

        })
        .then((response) => response.data)
}
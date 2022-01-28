import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";


export function getCard() {
    return axiosInterceptor.get("/bataille/tirer").then((response) => response.data);
}

export function jouer(signe) {
    return axiosInterceptor
        .get('http://localhost:6237/pfc/jouer?signe=' + signe, { 

        })
        .then((response) => response.data)
}


import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";

export function getCard() {
    return axiosInterceptor.get("/bataille/tirer").then((response) => response.data);
}

export function startRound(round) {
    return axios
        .post('http://localhost:8080/bataille/start?nbRound=' + round, { 

        })
        .then((response) => response.data)
}
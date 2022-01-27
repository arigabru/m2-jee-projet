import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";

export function getCard() {
    return axiosInterceptor.get("/bataille/tirer").then((response) => response.data);
}

export function startRound(round) {
    return axiosInterceptor
        .post('http://localhost:6237/bataille/start?nbRound=' + round, { 

        })
        .then((response) => response.data)
}
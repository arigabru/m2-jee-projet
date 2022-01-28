import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";

export function getCard() {
    return axiosInterceptor.get("/blackjack/tirer").then((response) => response.data);
}

export function startRound(round) {
    return axiosInterceptor
        .post('http://localhost:3000/blackjack/start?nbRound=' + round, { 

        })
        .then((response) => response.data)
}
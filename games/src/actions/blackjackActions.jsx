import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";

export function getCard() {
    return axiosInterceptor.get("/blackjack/tirer").then((response) => response.data);
}

export function stopDraw() {
    return axiosInterceptor.get("/blackjack/stop").then((response) => response.data);
}

export function startRound(round) {
    return axiosInterceptor
        .get('/blackjack/start?nbRound=' + round, { 

        })
        .then((response) => response.data)
}

export function nextRound() {
    return axiosInterceptor.get("/blackjack/nextRound").then((response) => response.data);
}
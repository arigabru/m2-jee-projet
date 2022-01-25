import { axiosInterceptor } from '../actions/axiosInterceptor';

export function getCard() {
    return axiosInterceptor.get("/bataille/paquet/carteRand").then((response) => response.data.data);
}
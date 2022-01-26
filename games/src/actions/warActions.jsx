import { axiosInterceptor } from '../actions/axiosInterceptor';

export function getCard() {
    return axiosInterceptor.get("/bataille/carteRand").then((response) => response.data);
}
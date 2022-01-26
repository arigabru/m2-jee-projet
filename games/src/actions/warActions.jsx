import { axiosInterceptor } from '../actions/axiosInterceptor';

export function getCard() {
    return axiosInterceptor.get("/bataille/tirer").then((response) => response.data);
}
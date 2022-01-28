import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";


export function getAdmin(mail) {
    return axiosInterceptor.get("/api/user/admin?mail=" + mail).then((response) => response.data);
}




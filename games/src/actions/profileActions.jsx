import { axiosInterceptor } from '../actions/axiosInterceptor';
import axios from "axios";

export function getUsers() {
    return axiosInterceptor.get("/api/users").then((response) => response.data);
}

export function deleteUser(mail) {
    return axiosInterceptor.delete("/api/users/delete?mail=" + mail)
}


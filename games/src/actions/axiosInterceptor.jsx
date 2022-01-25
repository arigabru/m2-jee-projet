import axios from "axios";

export const axiosInterceptor = axios.create({
    baseUrl: 'http://localhost:8080'
});

axiosInterceptor.interceptors.request.use(request => {

    const storedJwt = localStorage.getItem('token')
    if (storedJwt) {
        request.headers.common.Authorization = `Bearer ${storedJwt}`;
    }
    return request
})

axiosInterceptor.defaults.baseURL = 'http://localhost:8080'

export default axiosInterceptor;
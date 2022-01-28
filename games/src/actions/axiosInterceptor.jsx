import axios from "axios";

export const axiosInterceptor = axios.create({
    baseUrl: 'http://localhost:6237'
});

axiosInterceptor.interceptors.request.use(request => {

    const storedJwt = sessionStorage.getItem('token') 
    if (storedJwt) {
        request.headers.common.Authorization = `Token ${storedJwt}`;
    }
    return request
})

axiosInterceptor.defaults.baseURL = 'http://localhost:6237'

export default axiosInterceptor;
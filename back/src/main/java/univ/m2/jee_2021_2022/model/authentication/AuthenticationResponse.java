package univ.m2.jee_2021_2022.model.authentication;

public class AuthenticationResponse {
    
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return this.jwt;
    }


}

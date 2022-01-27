package univ.m2.jee_2021_2022.authentication.models;

public class AuthenticationResponse {
    
    private final String jwt;
    private String pseudo;
    private String email;

    public AuthenticationResponse(String jwt, String pseudo, String email) {
        this.jwt = jwt;
        this.pseudo = pseudo;
        this.email = email;
    }

    public String getJwt() {
        return this.jwt;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public String getEmail() {
        return this.email;
    }


}

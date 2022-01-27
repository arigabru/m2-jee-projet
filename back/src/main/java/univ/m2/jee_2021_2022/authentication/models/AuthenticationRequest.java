package univ.m2.jee_2021_2022.authentication.models;

import org.springframework.data.annotation.Id;

public class AuthenticationRequest {
    
    private String pseudo;
    private String password;
    @Id
    private String email;
    private Boolean administrator;

    public AuthenticationRequest() {
        
    }
  
    public AuthenticationRequest(String pseudo, String password, String email) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.administrator = false;
    }
    
    public AuthenticationRequest(String pseudo, String password, String email, Boolean administrator) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.administrator = administrator;
    }
    
    public AuthenticationRequest(AuthenticationRequest user) {
        this.pseudo = user.getPseudo();
        //this.password = password;
        this.email = user.getEmail();
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdministrator(){
        return this.administrator;
    }
    public void setAdministrator(Boolean administrator){
        this.administrator = administrator;
    }

    
}

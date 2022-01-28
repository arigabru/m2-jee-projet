package univ.m2.jee_2021_2022.authentication.models;

import org.springframework.data.annotation.Id;

public class Games {
    
    @Id
    private int id;
    private Boolean pfc;
    private Boolean bataille;
    private Boolean blj;

    public Games(){
    }

    public Games(int id, Boolean p, Boolean b, Boolean ba){
        this.id = id;
        this.pfc = p;
        this.bataille = ba;
        this.blj = b;
        
    }

    public int getId(){
        return this.id;
    }

    public Boolean getPFC(){
        return this.pfc;
    }

    public Boolean getBataille(){
        return this.bataille;
    }

    public Boolean getBlj(){
        return this.blj;
    }

}

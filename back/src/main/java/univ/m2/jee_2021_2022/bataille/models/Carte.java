package univ.m2.jee_2021_2022.bataille.models;

public class Carte {

    private Valeur valeur;
    private Couleur couleur;

    public Carte(Valeur valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }
    
    public String getName() {
        return this.valeur.getName() + this.couleur.getName();
    }
}
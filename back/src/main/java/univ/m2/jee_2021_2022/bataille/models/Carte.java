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

    public void setValeur(Valeur valeur) {
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    
    public String getName() {
        return this.valeur.getName() + this.couleur.getName();
    }
}

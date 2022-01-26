package univ.m2.jee_2021_2022.bataille.models;

public class ResultatBataille {
    private String carteJoueur;
    private String carteBot;
    private int rapport;

    public ResultatBataille(Carte carteJoueur, Carte carteBot, int rapport) {
        this.carteJoueur = carteJoueur.getName();
        this.carteBot = carteBot.getName();
        this.rapport = rapport;
    }

    public String getCarteJoueur() {
        return this.carteJoueur;
    }

    public String getCarteBot() {
        return this.carteBot;
    }

    public int getRapport() {
        return this.rapport;
    }
}

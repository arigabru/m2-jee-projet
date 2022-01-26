package univ.m2.jee_2021_2022.model.bataille;

public class ResultatRound {
    private String carteJoueur;
    private String carteBot;
    private int rapport;

    public ResultatRound(Carte carteJoueur, Carte carteBot) {
        this.carteJoueur = carteJoueur.getName();
        this.carteBot = carteBot.getName();
        this.rapport = carteJoueur.getValeur().comparer(carteBot.getValeur());
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

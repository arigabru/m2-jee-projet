package univ.m2.jee_2021_2022.bataille.models;

/**
 * Constitue l'information envoyé au client
 */
public class EtatPartie {

    private int nbRound;
    private int roundActuel;
    private int score;

    private String carteJoueur;
    private String carteBot;
    private int rapport;

    public EtatPartie(int nbRound, int roundActuel, int score, Carte carteJoueur, Carte carteBot, int rapport) {
        this.nbRound = nbRound;
        this.roundActuel = roundActuel;
        this.score = score;
        this.carteJoueur = carteJoueur.getName();
        this.carteBot = carteBot.getName();
        this.rapport = rapport;
    }

    public int getNbRound() {
        return this.nbRound;
    }

    public int getRoundActuel() {
        return this.roundActuel;
    }

    public int getScore() {
        return this.score;
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

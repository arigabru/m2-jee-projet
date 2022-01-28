package univ.m2.jee_2021_2022.pfc.models;

/**
 * Constitue l'information envoyé au client
 */
public class EtatPfcDTO {
    private String mainJoueur;
    private String mainBot;
    private int rapport;
    private int scoreJoueur;
    private int scoreBot;
    private int roundActuel;
    private int nbRound;

    public EtatPfcDTO(Main carteJoueur, Main carteBot, int rapport, int scoreJoueur, int scoreBot, int roundActuel, int nbRound) {
        this.mainJoueur = carteJoueur.name();
        this.mainBot = carteBot.name();
        this.rapport = rapport;
        this.scoreJoueur = scoreJoueur;
        this.scoreBot = scoreBot;
        this.roundActuel = roundActuel;
        this.nbRound = nbRound;
    }

    public String getMainJoueur() {
        return this.mainJoueur;
    }

    public String getMainBot() {
        return this.mainBot;
    }

    public int getRapport() {
        return this.rapport;
    }

    public int getScoreJoueur() {
        return this.scoreJoueur;
    }

    public int getScoreBot() {
        return this.scoreBot;
    }

    public int getRoundActuel() {
        return this.roundActuel;
    }

    public int getNbRound() {
        return this.nbRound;
    }
}

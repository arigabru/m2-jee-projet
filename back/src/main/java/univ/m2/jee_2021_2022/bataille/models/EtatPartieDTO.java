package univ.m2.jee_2021_2022.bataille.models;

/**
 * Constitue l'information envoyé au client
 */
public class EtatPartieDTO {

    private int nbRound;
    private int roundActuel;
    private int scoreJoueur;
    private int scoreBot;

    private String carteJoueur;
    private String carteBot;
    private int rapport;

<<<<<<< HEAD
    public EtatPartieDTO(int nbRound, int roundActuel, int scoreJoueur, int scoreBot, Carte carteJoueur, Carte carteBot, int rapport) {
=======
    public EtatPartieDTO(int nbRound, int roundActuel, int scoreJoueur, int scoreBot, CarteDTO carteJoueur, CarteDTO carteBot, int rapport) {
>>>>>>> c943c45e64b63bdcaae0f301a47c17b82f58d477
        this.nbRound = nbRound;
        this.roundActuel = roundActuel;
        this.scoreJoueur = scoreJoueur;
        this.scoreBot = scoreBot;
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

    public int getScoreJoueur() {
        return this.scoreJoueur;
    }

    public int getScoreBot() {
        return this.scoreBot;
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

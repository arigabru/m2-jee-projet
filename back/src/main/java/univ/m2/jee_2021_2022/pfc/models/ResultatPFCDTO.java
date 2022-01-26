package univ.m2.jee_2021_2022.pfc.models;

/**
 * Constitue l'information envoyé au client
 */
public class ResultatPFC {
    private String mainJoueur;
    private String mainBot;
    private int rapport;

    public ResultatPFC(Main carteJoueur, Main carteBot, int rapport) {
        this.mainJoueur = carteJoueur.name();
        this.mainBot = carteBot.name();
        this.rapport = rapport;
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
}

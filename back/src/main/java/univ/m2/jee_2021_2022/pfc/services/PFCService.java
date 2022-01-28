package univ.m2.jee_2021_2022.pfc.services;

import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.pfc.models.Main;

@Service
public class PFCService {

    private int scoreJoueur;
    private int scoreBot;
    private int nbRound;
    private int roundActuel;

    public PFCService() {
        this.scoreJoueur = 0;
        this.scoreBot = 0;
        this.nbRound = 0;
        this.roundActuel = 0;
    }

    public Main signeAleatoire() {
        return Main.values()[(int) (Math.random()*Main.values().length)];
    }

    public void nouvellePartie(int nbRound) {
        this.nbRound = nbRound;
        this.roundActuel = 1;
        this.scoreJoueur = 0;
        this.scoreBot = 0;
    }

    public boolean roundSuivant() {
        if (this.roundActuel <= this.nbRound) {
            this.roundActuel++;
            return true;
        }
        return false;
    }

    public int comparer(Main m1, Main m2) {
        if (this.roundSuivant()) {
            if (m1.equals(Main.Pierre)) {
                if (m2.equals(Main.Feuille)) {
                    this.scoreBot++;
                    return -1;
                }
                if (m2.equals(Main.Ciseaux)) {
                    this.scoreJoueur++;
                    return -1;
                }
            }
            else if (m1.equals(Main.Feuille)) {
                if (m2.equals(Main.Ciseaux)) {
                    this.scoreBot++;
                    return -1;
                }
                if (m2.equals(Main.Pierre)) {
                    this.scoreJoueur++;
                    return -1;
                }
            }
            else if (m1.equals(Main.Ciseaux)) {
                if (m2.equals(Main.Pierre)) {
                    this.scoreBot++;
                    return -1;
                }
                if (m2.equals(Main.Feuille)) {
                    this.scoreJoueur++;
                    return -1;
                }
            }
        }
        return 0;
    }

    public int getScoreJoueur() {
        return this.scoreJoueur;
    }

    public void setScoreJoueur(int scoreJoueur) {
        this.scoreJoueur = scoreJoueur;
    }

    public int getScoreBot() {
        return this.scoreBot;
    }

    public void setScoreBot(int scoreBot) {
        this.scoreBot = scoreBot;
    }

    public int getNbRound() {
        return this.nbRound;
    }

    public void setNbRound(int nbRound) {
        this.nbRound = nbRound;
    }

    public int getRoundActuel() {
        return this.roundActuel;
    }

    public void setRoundActuel(int roundActuel) {
        this.roundActuel = roundActuel;
    }
}

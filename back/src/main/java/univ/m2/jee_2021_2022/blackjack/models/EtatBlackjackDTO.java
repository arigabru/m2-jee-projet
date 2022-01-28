package univ.m2.jee_2021_2022.blackjack.models;

import java.util.ArrayList;

import univ.m2.jee_2021_2022.blackjack.models.CarteDTO;

public class EtatBlackjackDTO {
    private int nbRound;
    private int roundActuel;
    private int scoreJoueur;
    private int scoreBot;

    private ArrayList<String> deckJoueur;
    private ArrayList<String> deckBot;
    private boolean coupPossibleJoueur;
	private int sommeJoueur;

    public EtatBlackjackDTO(int nbRound, int roundActuel, int scoreJoueur, int scoreBot, ArrayList<String> deckJoueur, ArrayList<String> deckBot, boolean coupPossibleJoueur, int sommeJoueur) {
        this.nbRound = nbRound;
        this.roundActuel = roundActuel;
        this.scoreJoueur = scoreJoueur;
        this.scoreBot = scoreBot;
        this.deckJoueur = deckJoueur;
        this.deckBot = deckBot;
        this.coupPossibleJoueur = coupPossibleJoueur;
        this.sommeJoueur = sommeJoueur;
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

    public ArrayList<String> getDeckJoueur() {
        return this.deckJoueur;
    }

    public ArrayList<String> getDeckBot() {
        return this.deckBot;
    }

    public boolean getCoupPossibleJoueur() {
        return this.coupPossibleJoueur;
    }

    public int getSommeJoueur() {
        return this.sommeJoueur;
    }
}
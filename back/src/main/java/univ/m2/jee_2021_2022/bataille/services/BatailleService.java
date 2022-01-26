package univ.m2.jee_2021_2022.bataille.services;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.bataille.models.Carte;
import univ.m2.jee_2021_2022.bataille.models.Couleur;
import univ.m2.jee_2021_2022.bataille.models.Valeur;

@Service
public class BatailleService {

    private ArrayList<Carte> paquet;

    private int nbRound;
    private int roundActuel;
    private int score;

    public BatailleService() {
        paquet = new ArrayList<>();
        for (Valeur v : Valeur.values()) {
            for (Couleur c : Couleur.values()) {
                paquet.add(new Carte(v, c));
            }
        }
        Collections.shuffle(paquet);
        this.nbRound = 1;
        this.roundActuel = 1;
        this.score = 0;
    }

    public void resetPaquet() {
        paquet = new ArrayList<>();
        for (Valeur v : Valeur.values()) {
            for (Couleur c : Couleur.values()) {
                paquet.add(new Carte(v, c));
            }
        }
        Collections.shuffle(paquet);
    }

    public void nouvellePartie(int nbRound) {
        this.nbRound = nbRound;
        this.roundActuel = 1;
        this.score = 0;
    }

    public boolean roundSuivant() {
        if (this.roundActuel <= this.nbRound) {
            this.roundActuel++;
            if (this.paquet.size() < 2) this.resetPaquet();
            return true;
        }
        return false;
    }

    public void gainManche() {
        this.score++;
    }

    public Carte tirerCarte() {
        return this.paquet.remove(0);
    }

    public int comparerCarte(Carte c1, Carte c2) {
        return c1.getValeur().comparer(c2.getValeur());
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

    public ArrayList<Carte> getPaquet() {
        return this.paquet;
    }
}

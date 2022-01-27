package univ.m2.jee_2021_2022.bataille.services;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.bataille.models.CarteDTO;
import univ.m2.jee_2021_2022.bataille.models.Couleur;
import univ.m2.jee_2021_2022.bataille.models.Valeur;

@Service
public class BatailleService {

    private ArrayList<CarteDTO> paquet;

    private int nbRound;
    private int roundActuel;
    private int scoreJoueur;
    private int scoreBot;

    public BatailleService() {
        paquet = new ArrayList<>();
        for (Valeur v : Valeur.values()) {
            for (Couleur c : Couleur.values()) {
                paquet.add(new CarteDTO(v, c));
            }
        }
        Collections.shuffle(paquet);
        this.nbRound = 1;
        this.roundActuel = 1;
        this.scoreJoueur = 0;
        this.scoreBot = 0;
    }

    public void resetPaquet() {
        paquet = new ArrayList<>();
        for (Valeur v : Valeur.values()) {
            for (Couleur c : Couleur.values()) {
                paquet.add(new CarteDTO(v, c));
            }
        }
        Collections.shuffle(paquet);
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
            if (this.paquet.size() < 2) this.resetPaquet();
            return true;
        }
        return false;
    }

    public void gainManche() {
        this.scoreJoueur++;
    }

    public void echechManche() {
        this.scoreBot++;
    }

    public CarteDTO tirerCarte() {
        return this.paquet.remove(0);
    }

    public int comparerCarte(CarteDTO c1, CarteDTO c2) {
        return c1.getValeur().comparer(c2.getValeur());
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

    public ArrayList<CarteDTO> getPaquet() {
        return this.paquet;
    }
}

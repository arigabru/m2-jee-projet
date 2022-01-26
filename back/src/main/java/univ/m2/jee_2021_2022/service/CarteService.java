package univ.m2.jee_2021_2022.service;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.model.bataille.Carte;
import univ.m2.jee_2021_2022.model.bataille.Couleur;
import univ.m2.jee_2021_2022.model.bataille.Valeur;

@Service
public class CarteService {

    private ArrayList<Carte> paquet;

    public CarteService() {
        paquet = new ArrayList<>();
        for (Valeur v : Valeur.values()) {
            for (Couleur c : Couleur.values()) {
                paquet.add(new Carte(v, c));
            }
        }
        Collections.shuffle(paquet);
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

    public Carte tirerCarte() {
        return this.paquet.remove(0);
    }

    public int comparerCarte(Carte c1, Carte c2) {
        return c1.getValeur().comparer(c2.getValeur());
    }
}

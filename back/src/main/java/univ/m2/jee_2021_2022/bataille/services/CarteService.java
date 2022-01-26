package univ.m2.jee_2021_2022.bataille.services;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.bataille.models.Carte;
import univ.m2.jee_2021_2022.bataille.models.Couleur;
import univ.m2.jee_2021_2022.bataille.models.Valeur;

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

package univ.m2.jee_2021_2022.model.bataille;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {

    private ArrayList<Carte> paquet;

    public Paquet() {
        this.paquet = new ArrayList<>();
    }

    public ArrayList<Carte> getPaquet() {
        return this.paquet;
    }

    public int size() {
        return this.paquet.size();
    }

    public void ajouterCarte(Carte c) {
        this.paquet.add(c);
    }

    public Carte tirerCarte() {
        return this.paquet.remove(0);
    }

    public void remplirPaquet() {
        this.paquet = new ArrayList<>();
        for (Valeur v : Valeur.values()) {
            for (Couleur c : Couleur.values()) {
                paquet.add(new Carte(v, c));
            }
        }
        Collections.shuffle(paquet);
    }
}
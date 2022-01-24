package univ.m2.jee_2021_2022.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.model.bataille.Carte;
import univ.m2.jee_2021_2022.model.bataille.Couleur;
import univ.m2.jee_2021_2022.model.bataille.Valeur;

@Service
public class CarteService {

    public ArrayList<Carte> getPaquet() {
        ArrayList<Carte> alCarte = new ArrayList<>();
        for (Valeur v : Valeur.values()) {
            for (Couleur c : Couleur.values()) {
                alCarte.add(new Carte(v, c));
            }
        }
        Collections.shuffle(alCarte);
        return alCarte;
    }

    public int comparerCarte(Carte c1, Carte c2) {
        return (c1.getValeur().compareTo(c2.getValeur()));
    }
}

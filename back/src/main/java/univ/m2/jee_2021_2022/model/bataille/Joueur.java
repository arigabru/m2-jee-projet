package univ.m2.jee_2021_2022.model.bataille;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private String pseudo;
    private List<Carte> deck;

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        this.deck = new ArrayList<>();
    }

    public Joueur(String pseudo, List deck) {
        this.pseudo = pseudo;
        this.deck = deck;
    }

    public void ajouterCarte(Carte carte) {
        this.deck.add(carte);
    }

    public Carte retirerCarte() {
        return this.deck.remove(0);
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<Carte> getDeck() {
        return deck;
    }

    public void setDeck(List<Carte> deck) {
        this.deck = deck;
    }
}

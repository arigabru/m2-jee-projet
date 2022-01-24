package univ.m2.jee_2021_2022.model.bataille;

public class Joueur {

    private String pseudo;
    private Paquet deck;

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        this.deck = new Paquet();
    }

    public void ajouterCarte(Carte carte) {
        this.deck.ajouterCarter(carte);
    }

    public Carte retirerCarte() {
        return this.deck.tirerCarte();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Paquet getDeck() {
        return this.deck;
    }

    public void setDeck(Paquet deck) {
        this.deck = deck;
    }
}

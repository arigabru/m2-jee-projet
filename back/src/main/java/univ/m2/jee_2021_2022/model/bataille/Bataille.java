package univ.m2.jee_2021_2022.model.bataille;

public class Bataille {
    
    private Joueur joueur;
    private Joueur bot;

    private Paquet paquetJoueur;
    private Paquet paquetBot;

    private boolean enCours;
    private boolean victoire;

    public Bataille(String pseudo) {
        this.joueur = new Joueur(pseudo);
        this.bot = new Joueur("Ordinateur");
        this.paquetJoueur = new Paquet();
        this.paquetBot = new Paquet();
        this.enCours = true;
        this.victoire = false;

        paquetJoueur.remplirPaquet();
        for (int i = 0; i < paquetJoueur.size()/2; i++) {
            paquetBot.ajouterCarte(paquetJoueur.tirerCarte());
        }
    }

    public Joueur getJoueur() {
        return this.joueur;
    }

    public Joueur getBot() {
        return this.bot;
    }

    public Paquet getPaquetJoueur() {
        return this.paquetJoueur;
    }

    public Paquet getPaquetBot() {
        return this.paquetBot;
    }

    public boolean isEnCours() {
        return this.enCours;
    }

    public boolean isVictoire() {
        return this.victoire;
    }

    public void setPaquetJoueur(Paquet paquetJoueur) {
        this.paquetJoueur = paquetJoueur;
    }

    public void setPaquetBot(Paquet paquetBot) {
        this.paquetBot = paquetBot;
    }

    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

    public void setVictoire(boolean victoire) {
        this.victoire = victoire;
    }
}

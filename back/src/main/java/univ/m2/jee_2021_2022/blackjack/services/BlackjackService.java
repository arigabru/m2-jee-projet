package univ.m2.jee_2021_2022.blackjack.services;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.bataille.models.CarteDTO;
import univ.m2.jee_2021_2022.bataille.models.Couleur;
import univ.m2.jee_2021_2022.bataille.models.Valeur;

@Service
public class BlackjackService {

    private ArrayList<CarteDTO> paquet;

    private int nbRound;
    private int roundActuel;
    private int scoreJoueur;
    private int scoreBot;

    private ArrayList<CarteDTO> deckJoueur;
    private ArrayList<CarteDTO> deckBot;
    private boolean coupPossibleJoueur;
	private int sommeJoueur;
    // private boolean coupPossibleBot;

    public BlackjackService() {
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
        this.deckJoueur = new ArrayList<CarteDTO>();
        this.deckBot = new ArrayList<CarteDTO>();
        this.coupPossibleJoueur = true;
		this.sommeJoueur = 0;
        // this.coupPossibleBot = true;
    }

    public void resetPaquet() {
        paquet = new ArrayList<>();
        for (Valeur v : Valeur.values()) {
            for (Couleur c : Couleur.values()) {
                paquet.add(new CarteDTO(v, c));
            }
        }
        Collections.shuffle(paquet);

        this.deckJoueur = new ArrayList<CarteDTO>();
        this.deckBot = new ArrayList<CarteDTO>();
        this.coupPossibleJoueur = true;
		this.sommeJoueur = 0;
        // this.coupPossibleBot = true;
    }

    public void nouvellePartie(int nbRound) {
        this.nbRound = nbRound;
        this.roundActuel = 1;
        this.resetPaquet();
        this.scoreJoueur = 0;
        this.scoreBot = 0;
    }

    public boolean roundSuivant() {
        if (this.roundActuel <= this.nbRound) {
            this.roundActuel++;
        	this.resetPaquet();
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

    public boolean tirerCarteJoueur() {
        this.deckJoueur.add(this.paquet.remove(0));

		int somme = 0;
		int nbAs = 0;
		for (CarteDTO c : this.deckJoueur) {
			if (c.getValeur().getValeur() != 14)
				somme += c.getValeur().getValeur();
			else
				nbAs++;
		}
		while (nbAs > 0) {
			if (somme + 10 + (nbAs-1) <=21 ) {
				somme += 10;
			} else {
				somme += 1;
			}
			nbAs--;
		}
		if (somme > 21) this.coupPossibleJoueur = false;
		this.sommeJoueur = somme;
		return this.coupPossibleJoueur;
    }

	public boolean tourBot() {
        this.deckBot.add(this.paquet.remove(0));

		int somme = 0;
		int nbAs = 0;
		for (CarteDTO c : this.deckBot) {
			if (c.getValeur().getValeur() != 14)
				somme += c.getValeur().getValeur();
			else
				nbAs++;
		}
		while (nbAs > 0) {
			if (somme + 10 + (nbAs-1) <=21 ) {
				somme += 10;
			} else {
				somme += 1;
			}
			nbAs--;
		}
		if (somme < 17) this.tourBot();
		else {
			if (somme > 21 || somme > this.sommeJoueur) {
				this.echechManche();
				return false;
			} else {
				this.gainManche();
				return true;
			}
		}
		return false;
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

	public boolean isCoupPossibleJoueur() {
		return this.coupPossibleJoueur;
	}

	public ArrayList<CarteDTO> getDeckJoueur() {
		return this.deckJoueur;
	}

	public ArrayList<CarteDTO> getDeckBot() {
		return this.deckBot;
	}

	public int getSommeJoueur() {
		return this.sommeJoueur;
	}
}

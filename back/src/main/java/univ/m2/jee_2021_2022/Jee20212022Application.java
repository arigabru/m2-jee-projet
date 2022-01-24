package univ.m2.jee_2021_2022;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import univ.m2.jee_2021_2022.model.bataille.Carte;
import univ.m2.jee_2021_2022.model.bataille.Couleur;
import univ.m2.jee_2021_2022.model.bataille.Valeur;
import univ.m2.jee_2021_2022.service.CarteService;
import univ.m2.jee_2021_2022.service.JoueurService;

@SpringBootApplication
public class Jee20212022Application implements CommandLineRunner {

	@Autowired
	private JoueurService joueurService;
	@Autowired
	private CarteService carteService;

	public static void main(String[] args) {
		SpringApplication.run(Jee20212022Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ArrayList<Carte> alCarte = carteService.getPaquet();

		for (Carte c : alCarte) {
			System.out.println(c);
		}

		Carte c1 = new Carte(Valeur.SEPT, Couleur.CARREAU);
		Carte c2 = new Carte(Valeur.VALET, Couleur.TREFLE);
		System.out.println(carteService.comparerCarte(c1, c2));
	}

}

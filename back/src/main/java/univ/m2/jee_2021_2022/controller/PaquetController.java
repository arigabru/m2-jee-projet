package univ.m2.jee_2021_2022.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univ.m2.jee_2021_2022.model.bataille.Carte;
import univ.m2.jee_2021_2022.model.bataille.Couleur;
import univ.m2.jee_2021_2022.model.bataille.Valeur;
import univ.m2.jee_2021_2022.service.CarteService;

@RestController
public class PaquetController {

    @Autowired
    private CarteService carteService;

    @GetMapping("/paquet/{id}/carteRand")
    public ResponseEntity<Carte> getCarteAleatoire(@RequestParam(value = "id") int id) {
        // À finir quand la base sera faite
        return ResponseEntity.ok(new Carte(Valeur.AS, Couleur.PIQUE));
    }

    @GetMapping("/comparer{c1}{c2}")
    public ResponseEntity<Integer> getComparaison(@RequestParam(value = "c1") Carte c1,
            @RequestParam(value = "c2") Carte c2) {
        return ResponseEntity.ok(carteService.comparerCarte(c1, c2));
    }
}
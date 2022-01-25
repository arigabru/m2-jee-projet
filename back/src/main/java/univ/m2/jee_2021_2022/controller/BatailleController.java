package univ.m2.jee_2021_2022.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univ.m2.jee_2021_2022.model.bataille.Carte;
import univ.m2.jee_2021_2022.model.bataille.Couleur;
import univ.m2.jee_2021_2022.model.bataille.Valeur;
import univ.m2.jee_2021_2022.service.CarteService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bataille")
public class BatailleController {

    @Autowired
    private CarteService carteService;

    @GetMapping("/carteRand")
    public ResponseEntity<Carte> getCarteAleatoire() {
        // À finir quand la base sera faite
        return ResponseEntity.ok(new Carte(Valeur.AS, Couleur.PIQUE));
    }

    @GetMapping("/comparer{c1}{c2}")
    public ResponseEntity<Integer> getComparaison(@RequestParam(value = "c1") Carte c1,
            @RequestParam(value = "c2") Carte c2) {
        return ResponseEntity.ok(carteService.comparerCarte(c1, c2));
    }
}

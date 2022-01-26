package univ.m2.jee_2021_2022.bataille.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import univ.m2.jee_2021_2022.bataille.models.Carte;
import univ.m2.jee_2021_2022.bataille.models.ResultatBataille;
import univ.m2.jee_2021_2022.bataille.services.CarteService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bataille")
public class BatailleController {

    @Autowired
    private CarteService carteService;

    @GetMapping("/tirer")
    public ResponseEntity<ResultatBataille> getCarteAleatoire() {

        carteService.resetPaquet();
        Carte c1 = carteService.tirerCarte();
        Carte c2 = carteService.tirerCarte();
        ResultatBataille resultat = new ResultatBataille(c1, c2, carteService.comparerCarte(c1, c2));
        return ResponseEntity.ok(resultat);
    }
}

package univ.m2.jee_2021_2022.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univ.m2.jee_2021_2022.model.bataille.Carte;
import univ.m2.jee_2021_2022.model.bataille.Couleur;
import univ.m2.jee_2021_2022.model.bataille.Paquet;
import univ.m2.jee_2021_2022.model.bataille.ResultatRound;
import univ.m2.jee_2021_2022.model.bataille.Valeur;
import univ.m2.jee_2021_2022.service.CarteService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bataille")
public class BatailleController {

    @Autowired
    private CarteService carteService;

    @GetMapping("/tirer")
    public ResponseEntity<ResultatRound> getCarteAleatoire() {

        ArrayList<Carte> paquet = carteService.getPaquet();
        Carte c1 = paquet.remove(0);
        Carte c2 = paquet.remove(0);
        ResultatRound resultat = new ResultatRound(c1, c2);
        return ResponseEntity.ok(resultat);
    }
}

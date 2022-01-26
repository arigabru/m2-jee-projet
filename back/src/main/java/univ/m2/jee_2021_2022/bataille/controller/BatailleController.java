package univ.m2.jee_2021_2022.bataille.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import univ.m2.jee_2021_2022.bataille.models.Carte;
import univ.m2.jee_2021_2022.bataille.models.ResultatBataille;
import univ.m2.jee_2021_2022.bataille.services.BatailleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bataille")
public class BatailleController {

    @Autowired
    private BatailleService batailleService;

    @PostMapping("/start")
    @ResponseStatus(value = HttpStatus.OK)
    public void jouer(@RequestParam(value = "nbRound") int nbRound) {

        batailleService.resetPaquet();
        batailleService.nouvellePartie(nbRound);
    }

    @GetMapping("/tirer")
    public ResponseEntity<ResultatBataille> tirer() {

        if (batailleService.roundSuivant()) {
            Carte c1 = batailleService.tirerCarte();
            Carte c2 = batailleService.tirerCarte();
            int rapport = batailleService.comparerCarte(c1, c2);
            ResultatBataille resultat = new ResultatBataille(c1, c2, rapport);
            if (rapport > 0) batailleService.gainManche();
            return ResponseEntity.ok(resultat);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/gameState")
    public ResponseEntity<BatailleService> gameState() {

        return ResponseEntity.ok(batailleService);
    }
}

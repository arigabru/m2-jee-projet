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
import univ.m2.jee_2021_2022.bataille.models.EtatPartie;
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
    public ResponseEntity<EtatPartie> tirer() {

        if (batailleService.roundSuivant()) {
            Carte c1 = batailleService.tirerCarte();
            Carte c2 = batailleService.tirerCarte();
            int rapport = batailleService.comparerCarte(c1, c2);
            if (rapport > 0) batailleService.gainManche();
            EtatPartie etatPartie = new EtatPartie(batailleService.getNbRound(),
                                                   batailleService.getRoundActuel(),
                                                   batailleService.getScore(),
                                                   c1,
                                                   c2,
                                                   rapport);
            return ResponseEntity.ok(etatPartie);
        }
        return ResponseEntity.ok(null);
    }
}

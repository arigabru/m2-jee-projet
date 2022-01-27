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

<<<<<<< HEAD
import univ.m2.jee_2021_2022.bataille.models.Carte;
=======
import univ.m2.jee_2021_2022.bataille.models.CarteDTO;
>>>>>>> c943c45e64b63bdcaae0f301a47c17b82f58d477
import univ.m2.jee_2021_2022.bataille.models.EtatPartieDTO;
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
    public ResponseEntity<EtatPartieDTO> tirer() {

        EtatPartieDTO etatPartie;
        if (batailleService.roundSuivant()) {
            CarteDTO c1 = batailleService.tirerCarte();
            CarteDTO c2 = batailleService.tirerCarte();
            int rapport = batailleService.comparerCarte(c1, c2);
            if (rapport > 0) batailleService.gainManche();
            if (rapport < 0) batailleService.echechManche();
<<<<<<< HEAD
            EtatPartieDTO etatPartie = new EtatPartieDTO(batailleService.getNbRound(),
=======
            etatPartie = new EtatPartieDTO(batailleService.getNbRound(),
>>>>>>> c943c45e64b63bdcaae0f301a47c17b82f58d477
                                                   batailleService.getRoundActuel(),
                                                   batailleService.getScoreJoueur(),
                                                   batailleService.getScoreBot(),
                                                   c1,
                                                   c2,
                                                   rapport);
        } else {
            etatPartie = new EtatPartieDTO(batailleService.getNbRound(),
            batailleService.getRoundActuel(),
            batailleService.getScoreJoueur(),
            batailleService.getScoreBot(),
            null,
            null,
            0);
        }
        return ResponseEntity.ok(etatPartie);
    }
}

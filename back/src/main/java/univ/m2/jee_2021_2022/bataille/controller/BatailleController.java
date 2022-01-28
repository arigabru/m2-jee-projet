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

import univ.m2.jee_2021_2022.authentication.services.GamesServices;
import univ.m2.jee_2021_2022.bataille.models.Carte;
import univ.m2.jee_2021_2022.bataille.models.EtatPartieDTO;
import univ.m2.jee_2021_2022.bataille.services.BatailleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bataille")
public class BatailleController {

    @Autowired
    private BatailleService batailleService;

    @Autowired
    private GamesServices gamesServices;

    @GetMapping("/start")
    @ResponseStatus(value = HttpStatus.OK)
    public void jouer(@RequestParam(value = "nbRound") String nbRound) {
        
        if (!isPlayable()){
            ResponseEntity.notFound();
        }
        
        batailleService.resetPaquet();
        batailleService.nouvellePartie(Integer.parseInt(nbRound));
        
       
    }

    @GetMapping("/tirer")
    public ResponseEntity<EtatPartieDTO> tirer() {

        if (!isPlayable()){
            ResponseEntity.notFound();
        }
        if (batailleService.roundSuivant()) {
            Carte c1 = batailleService.tirerCarte();
            Carte c2 = batailleService.tirerCarte();
            int rapport = batailleService.comparerCarte(c1, c2);
            if (rapport > 0) batailleService.gainManche();
            if (rapport < 0) batailleService.echechManche();
            EtatPartieDTO etatPartie = new EtatPartieDTO(batailleService.getNbRound(),
                                                   batailleService.getRoundActuel(),
                                                   batailleService.getScoreJoueur(),
                                                   batailleService.getScoreBot(),
                                                   c1,
                                                   c2,
                                                   rapport);
            return ResponseEntity.ok(etatPartie);
        }
        return ResponseEntity.ok(null);
    }

    public Boolean isPlayable(){
        return gamesServices.getInformationGames().getBataille();
    }
}

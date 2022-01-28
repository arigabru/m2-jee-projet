package univ.m2.jee_2021_2022.bataille.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import univ.m2.jee_2021_2022.authentication.services.GamesServices;
import univ.m2.jee_2021_2022.bataille.models.CarteDTO;
import univ.m2.jee_2021_2022.bataille.models.EtatBatailleDTO;
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
    public ResponseEntity<?> jouer(@RequestParam(value = "nbRound") String nbRound) {
        
        if (!isPlayable()){
            return new ResponseEntity("{\"information\" : \"battle not activated\"}" ,HttpStatus.BAD_REQUEST);
        }
        
        batailleService.resetPaquet();
        batailleService.nouvellePartie(Integer.parseInt(nbRound));
        return new ResponseEntity("{\"information\" : \"Start battle\"}" ,HttpStatus.OK);
       
    }

    @GetMapping("/tirer")
    public ResponseEntity<EtatBatailleDTO> tirer() {

        if (!isPlayable()){
            return new ResponseEntity("{\"information\" : \"battle not activated\"}" ,HttpStatus.BAD_REQUEST);
        }
        if (batailleService.roundSuivant()) {
            CarteDTO c1 = batailleService.tirerCarte();
            CarteDTO c2 = batailleService.tirerCarte();
            int rapport = batailleService.comparerCarte(c1, c2);
            if (rapport > 0) batailleService.gainManche();
            if (rapport < 0) batailleService.echecManche();
            EtatBatailleDTO etatPartie = new EtatBatailleDTO(batailleService.getNbRound(),
                                                   batailleService.getRoundActuel(),
                                                   batailleService.getScoreJoueur(),
                                                   batailleService.getScoreBot(),
                                                   c1,
                                                   c2,
                                                   rapport);
            return ResponseEntity.ok(etatPartie);
        }
        return new ResponseEntity("{\"information\" : \"error you can't draw anymore\"}" ,HttpStatus.BAD_REQUEST);
    }

    public Boolean isPlayable(){
        return gamesServices.getInformationGames().getBataille();
    }
}

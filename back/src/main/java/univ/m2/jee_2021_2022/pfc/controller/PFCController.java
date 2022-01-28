package univ.m2.jee_2021_2022.pfc.controller;

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
import univ.m2.jee_2021_2022.pfc.models.Main;
import univ.m2.jee_2021_2022.pfc.models.EtatPfcDTO;
import univ.m2.jee_2021_2022.pfc.services.PFCService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pfc")
public class PFCController {

    @Autowired
    private PFCService pfcService;

    @Autowired
    private GamesServices gamesServices;

    @GetMapping("/start")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> start(@RequestParam(value = "nbRound") String nbRound) {
        
        if (!isPlayable()){
            return new ResponseEntity("{\"information\" : \"pfc not activated\"}" ,HttpStatus.BAD_REQUEST);
        }

        pfcService.nouvellePartie(Integer.parseInt(nbRound));
        return new ResponseEntity("{\"information\" : \"Start battle\"}" ,HttpStatus.OK);
       
    }

    @GetMapping("/jouer")
    public ResponseEntity<EtatPfcDTO> jouer(@RequestParam(value = "signe") Main mainJoueur) {
        if (!isPlayable()){
            return new ResponseEntity("{\"information\" : \"pfc not activate\"}" ,HttpStatus.BAD_REQUEST);
        }
        Main mainBot = pfcService.signeAleatoire();
        int rapport = pfcService.comparer(mainJoueur, mainBot);
        EtatPfcDTO resultat = new EtatPfcDTO(mainJoueur,
                                             mainBot,
                                             rapport,
                                             pfcService.getScoreJoueur(),
                                             pfcService.getScoreBot(),
                                             pfcService.getRoundActuel(),
                                             pfcService.getNbRound());
        return ResponseEntity.ok(resultat);
    }

    public Boolean isPlayable(){
        return gamesServices.getInformationGames().getPFC();
    }
}

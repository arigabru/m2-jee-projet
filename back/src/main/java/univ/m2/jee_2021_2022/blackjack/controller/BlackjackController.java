package univ.m2.jee_2021_2022.blackjack.controller;

import java.util.ArrayList;

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
import univ.m2.jee_2021_2022.blackjack.models.CarteDTO;
import univ.m2.jee_2021_2022.blackjack.models.EtatBlackjackDTO;
import univ.m2.jee_2021_2022.blackjack.services.BlackjackService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/blackjack")
public class BlackjackController {

    @Autowired
    private BlackjackService blackjackService;
    @Autowired
    private GamesServices gamesServices;

    @GetMapping("/start")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> jouer(@RequestParam(value = "nbRound") int nbRound) {
        if (isPlayable()){
            blackjackService.nouvellePartie(nbRound);
            return new ResponseEntity("{\"information\" : \"Start BlackJack\"}" ,HttpStatus.OK);
        }else {
             return new ResponseEntity("{\"information\" : \"BlackJack not activated\"}" ,HttpStatus.BAD_REQUEST);
        }
           
    }

    @GetMapping("/tirer")
    public ResponseEntity<EtatBlackjackDTO> tirer() {
        if (!isPlayable()){
            return new ResponseEntity("{\"information\" : \"BlackJack not activated\"}" ,HttpStatus.BAD_REQUEST);
        }
        if (blackjackService.isCoupPossibleJoueur()) {
            blackjackService.tirerCarteJoueur();
        }

        ArrayList<CarteDTO> deckJoueur = blackjackService.getDeckJoueur();
        ArrayList<CarteDTO> deckBot = blackjackService.getDeckBot();
        ArrayList<String> deckJoueurName = new ArrayList<>();
        ArrayList<String> deckBotName = new ArrayList<>();

        for (CarteDTO c : deckJoueur) {
            deckJoueurName.add(c.getName());
        }
        for (CarteDTO c : deckBot) {
            deckBotName.add(c.getName());
        }
        
        EtatBlackjackDTO etatPartie = new EtatBlackjackDTO(blackjackService.getNbRound(), 
                                                           blackjackService.getRoundActuel(),
                                                           blackjackService.getScoreJoueur(),
                                                           blackjackService.getScoreBot(),
                                                           deckJoueurName,
                                                           deckJoueurName,
                                                           blackjackService.isCoupPossibleJoueur(), 
                                                           blackjackService.getSommeJoueur());
        return ResponseEntity.ok(etatPartie);
    }

    @GetMapping("/stop")
    public ResponseEntity<EtatBlackjackDTO> tourBot() {
        if (!isPlayable()){
            return new ResponseEntity("{\"information\" : \"BlackJack not activated\"}" ,HttpStatus.BAD_REQUEST);
        }
        blackjackService.tourBot();

        ArrayList<CarteDTO> deckJoueur = blackjackService.getDeckJoueur();
        ArrayList<CarteDTO> deckBot = blackjackService.getDeckBot();
        ArrayList<String> deckJoueurName = new ArrayList<>();
        ArrayList<String> deckBotName = new ArrayList<>();

        for (CarteDTO c : deckJoueur) {
            deckJoueurName.add(c.getName());
        }
        for (CarteDTO c : deckBot) {
            deckBotName.add(c.getName());
        }
        
        EtatBlackjackDTO etatPartie = new EtatBlackjackDTO(blackjackService.getNbRound(),
                                                           blackjackService.getRoundActuel(),
                                                           blackjackService.getScoreJoueur(),
                                                           blackjackService.getScoreBot(),
                                                           deckJoueurName,
                                                           deckJoueurName,
                                                           blackjackService.isCoupPossibleJoueur(),
                                                           blackjackService.getSommeJoueur());
        return ResponseEntity.ok(etatPartie);
    }
    public Boolean isPlayable(){
        return gamesServices.getInformationGames().getBlj();
    }
}

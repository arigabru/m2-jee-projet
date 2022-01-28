package univ.m2.jee_2021_2022.blackjack.controller;

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

    @PostMapping("/start")
    @ResponseStatus(value = HttpStatus.OK)
    public void jouer(@RequestParam(value = "nbRound") int nbRound) {
        if (!isPlayable()){
            ResponseEntity.notFound();
        }
        blackjackService.nouvellePartie(nbRound);
    }

    @GetMapping("/tirer")
    public ResponseEntity<EtatBlackjackDTO> tirer() {
        if (!isPlayable()){
            ResponseEntity.notFound();
        }
        if (blackjackService.isCoupPossibleJoueur()) {
            blackjackService.tirerCarteJoueur();
        }
        EtatBlackjackDTO etatPartie = new EtatBlackjackDTO(blackjackService.getNbRound(), blackjackService.getRoundActuel(), blackjackService.getScoreJoueur(), blackjackService.getScoreBot(), blackjackService.getDeckJoueur(), blackjackService.getDeckBot(), blackjackService.isCoupPossibleJoueur(), blackjackService.getSommeJoueur());
        return ResponseEntity.ok(etatPartie);
    }

    @GetMapping("/stop")
    public ResponseEntity<EtatBlackjackDTO> tourBot() {
        if (!isPlayable()){
            ResponseEntity.notFound();
        }
        blackjackService.tourBot();
        EtatBlackjackDTO etatPartie = new EtatBlackjackDTO(blackjackService.getNbRound(), blackjackService.getRoundActuel(), blackjackService.getScoreJoueur(), blackjackService.getScoreBot(), blackjackService.getDeckJoueur(), blackjackService.getDeckBot(), blackjackService.isCoupPossibleJoueur(), blackjackService.getSommeJoueur());
        return ResponseEntity.ok(etatPartie);
    }
    public Boolean isPlayable(){
        return gamesServices.getInformationGames().getBlj();
    }
}

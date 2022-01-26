package univ.m2.jee_2021_2022.pfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univ.m2.jee_2021_2022.pfc.models.Main;
import univ.m2.jee_2021_2022.pfc.models.ResultatPFC;
import univ.m2.jee_2021_2022.pfc.services.PFCService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pfc")
public class PFCController {

    @Autowired
    private PFCService pfcService;

    @PostMapping("/jouer")
    public ResponseEntity<ResultatPFC> jouer(@RequestParam(value = "signe") Main mainJoueur) {

        Main mainBot = pfcService.signeAleatoire();
        int rapport = pfcService.comparer(mainJoueur, mainBot);
        
        ResultatPFC resultat = new ResultatPFC(mainJoueur, mainBot, rapport);
        return ResponseEntity.ok(resultat);
    }

    @GetMapping("/test")
    public ResponseEntity<Main> test() {

        return ResponseEntity.ok(Main.Ciseaux);
    }
}

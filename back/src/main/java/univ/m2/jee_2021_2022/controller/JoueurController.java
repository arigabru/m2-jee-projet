package univ.m2.jee_2021_2022.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univ.m2.jee_2021_2022.model.bataille.Joueur;

@RestController
public class JoueurController {

    @GetMapping("/joueur")
    public Joueur getJoueur(@RequestParam(value = "pseudo", defaultValue = "Pseudo") String pseudo) {
        return new Joueur(pseudo);
    }
}

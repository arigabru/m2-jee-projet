package univ.m2.jee_2021_2022.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JoueurController {

    @GetMapping("/joueur")
    public String getJoueur(Model model) {
        return "joueur";
    }
}

package univ.m2.jee_2021_2022.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.model.bataille.Joueur;
import univ.m2.jee_2021_2022.repository.JoueurRepository;

@Service
public class JoueurService {

    // @Autowired
    // private JoueurRepository repository;

    public Joueur getJoueur() {
        return new Joueur("Pseudo");
    }
}

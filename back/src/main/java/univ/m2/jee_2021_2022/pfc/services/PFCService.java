package univ.m2.jee_2021_2022.pfc.services;

import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.pfc.models.Main;

@Service
public class PFCService {

    public Main signeAleatoire() {
        return Main.values()[(int) (Math.random()*Main.values().length)];
    }

    public int comparer(Main m1, Main m2) {
        if (m1.equals(Main.Pierre)) {
            if (m2.equals(Main.Feuille)) return -1;
            if (m2.equals(Main.Ciseaux)) return 1;
        }
        else if (m1.equals(Main.Feuille)) {
            if (m2.equals(Main.Ciseaux)) return -1;
            if (m2.equals(Main.Pierre)) return 1;
        }
        else if (m1.equals(Main.Ciseaux)) {
            if (m2.equals(Main.Pierre)) return -1;
            if (m2.equals(Main.Feuille)) return 1;
        }
        return 0;
    }
}

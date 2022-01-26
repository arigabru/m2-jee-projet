package univ.m2.jee_2021_2022.bataille.models;

public enum Valeur {
    DEUX(2, "2"),
    TROIS(3, "3"),
    QUATRE(4, "4"),
    CINQ(5, "5"),
    SIX(6, "6"),
    SEPT(7, "7"),
    HUIT(8, "8"),
    NEUF(9, "9"),
    DIX(10, "T"),
    VALET(11, "J"),
    DAME(12, "Q"),
    ROI(13, "K"),
    AS(14, "A");

    private int valeur;
    private String name;

    Valeur(int valeur, String name) {
        this.valeur = valeur;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int comparer(Valeur v) {
        if (this.valeur < v.valeur) return -1;
        if (this.valeur > v.valeur) return 1;
        return 0;
    }
}

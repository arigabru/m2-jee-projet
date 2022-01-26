package univ.m2.jee_2021_2022.model.bataille;

public enum Couleur {
    CARREAU("d"),
    PIQUE("s"),
    TREFLE("c"),
    COEUR("h");

    private String name;

    Couleur(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

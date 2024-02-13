package org.centrale.domain;

public class Feuille implements Hand{

    @Override // cf https://projectlombok.org
    public String playWith(Hand h) {
        return h.playWithFeuille(this);
    }

    @Override
    public String playWithPierre(Pierre p) {
        return "Gagné";
    }

    @Override
    public String playWithCiseaux(Ciseaux c) {
        return "Perdu";
    }

    @Override
    public String playWithFeuille(Feuille f) {
        return "Egalité";
    }

    public String toString() {
        String result = "Feuille";
        return result;
    }
}

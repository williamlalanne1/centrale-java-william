package org.centrale.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor // cf https://projectlombok.org
public class Ciseaux implements Hand{

    @Override
    public String playWith(Hand h) {
        return h.playWithCiseaux(this);
    }

    @Override
    public String playWithPierre(Pierre p) {
        return "Perdu";
    }

    @Override
    public String playWithCiseaux(Ciseaux c) {
        return "Egalité";
    }

    @Override
    public String playWithFeuille(Feuille f) {
        return "Gagné";
    }

    public String toString() {
        String result = "Ciseaux";
        return result;
    }
}

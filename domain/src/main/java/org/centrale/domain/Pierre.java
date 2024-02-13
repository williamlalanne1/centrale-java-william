package org.centrale.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor // cf https://projectlombok.org
public class Pierre implements Hand {


    @Override
    public String playWith(Hand h) {
        return h.playWithPierre(this);
    }

    @Override
    public String playWithPierre(Pierre p) {
        return "Egalité";
    }

    @Override
    public String playWithCiseaux(Ciseaux c) {
        return "Gagné";
    }

    @Override
    public String playWithFeuille(Feuille f) {
        return "Perdu";
    }

    public String toString() {
        String result = "Pierre";
        return result;
    }
}

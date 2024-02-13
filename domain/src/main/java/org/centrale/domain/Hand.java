package org.centrale.domain;

public interface Hand {

    String playWith(Hand h);

    String playWithPierre(Pierre p);

    String playWithCiseaux(Ciseaux c);

    String playWithFeuille(Feuille f);

}

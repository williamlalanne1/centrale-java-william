package org.centrale.cli;

import org.centrale.domain.Ciseaux;
import org.centrale.domain.Feuille;
import org.centrale.domain.Hand;
import org.centrale.domain.Pierre;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Nouvelle partie de pierre feuille ciseaux !");
        Scanner scYou = new Scanner(System.in);
        System.out.println("Choisissez Pierre, Feuille, Ciseaux :");
        String yourChoice = scYou.nextLine();

        Hand yourPick;

        if (yourChoice.equals("Pierre")){
            yourPick = new Pierre();
        } else if (yourChoice.equals("Feuille")){
            yourPick = new Feuille();
        } else {
            yourPick = new Ciseaux();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Scanner scMe = new Scanner(System.in);
        System.out.println("Maintenant c'est à moi de choisir (Pierre, Feuille ou Ciseaux) :");
        String myChoice = scMe.nextLine();

        Hand myPick;

        if (myChoice.equals("Pierre")){
            myPick = new Pierre();
        } else if (myChoice.equals("Feuille")){
            myPick = new Feuille();
        } else {
            myPick = new Ciseaux();
        }

        String resultat = myPick.playWith(yourPick);

        if (resultat.equals("Gagné")){
            System.out.println("Vous avez gagné !");
        } else if (resultat.equals("Egalité")){
            System.out.println("Egalité !");
        } else if (resultat.equals("Perdu")){
            System.out.println("J'ai gagné !");
        }

    }
}

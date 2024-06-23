package org.example.pendu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IHM {

    // Méthode Start
    public static void start() {

        while (true) {
        Scanner sc = new Scanner(System.in);

            System.out.println("=== Menu ===");
            System.out.println("1. Jouer");
            System.out.println("2. Quitter");

            System.out.println("Sélectionner une option :");
            try {
                int choix;
                choix = sc.nextInt();
                System.out.println();
                switch (choix) {
                    case 1 -> lancerJeu();
                    case 2 -> {
                        //TODO pourquoi quitter après une partie renvoie NoSuchElementException
                        System.out.println("Exit");
                        sc.close();
                        return; // quitte la méthode start
                    }
                    default -> System.out.println("veuillez saisir l'une des options");
                }
            } catch (InputMismatchException e) {
                System.out.println("Veuillez saisir un chiffre");
                sc.nextLine();
//            } catch (NoSuchElementException e) {
//                System.out.println("oups");
            }

        }
    }

    // Méthode Pour lancer le jeu, en dehors de "start", appelée par "start"
    public static void lancerJeu() {
        Scanner scanner = new Scanner(System.in);

        char proposition;
        char[] resultat;
        int essaisMax;
        int essais = 1;

        System.out.println("Combien d'essais voulez-vous ?");


        essaisMax = scanner.nextInt();
        System.out.println("C'est parti pour " + essaisMax + " essais !");


        Mots mot = new Mots();
        String motAleatoire = mot.getMotAleatoire();

        char[] motMasque = mot.getMotMasque(motAleatoire);

        while (true) {
//            try { //TODO ajouter traitement de l'exception si saisie autre que lettre
            if (essais <= essaisMax) {
                System.out.println("Proposez une lettre : ");
                proposition = scanner.next().charAt(0);
                System.out.println("essai n°" + essais + " : " + proposition);
                resultat = mot.reponse(motMasque, motAleatoire, proposition);
                System.out.println(resultat);
                System.out.println();
                essais++;

                //System.out.println("On a dit une lettre ! ");
            } else {
                System.out.println("Game Over");
                start();
            }

//            }catch
        }
    }

}

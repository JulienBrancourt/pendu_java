package org.example.pendu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Mots {
    List<String> listeMots;

    public Mots() {
        listeMots = new ArrayList<>();
        listeMots.add("mot");
        listeMots.add("random");
        listeMots.add("test");
        listeMots.add("java");
        listeMots.add("java");
        listeMots.add("java");
        listeMots.add("java");
        listeMots.add("java");
        listeMots.add("java");
        listeMots.add("jeu");
    }

    public String getMotAleatoire() {
        Random random = new Random();// crée une instance de la classe Random, qui est utilisée pour générer des nombres aléatoires
        String motAleatoire = listeMots.get(random.nextInt(listeMots.size()));
        System.out.println("mot aléatoire : " +motAleatoire);
        return motAleatoire;
    }

    public char[] getMotMasque(String mot) {
        char[] motMasque = new char[mot.length()];
        Arrays.fill(motMasque, '_');
        System.out.println("Rendu du mot masqué : " + new String(motMasque));
        return motMasque;
    }

    public char[] reponse(char[] motMasque, String motOriginal, char proposition) {
        for (int i = 0; i < motOriginal.length(); i++) {
            if (motOriginal.charAt(i) == proposition) {
                motMasque[i] = proposition;
            }
        }
        if (String.valueOf(motMasque).equals(motOriginal)) {
            System.out.println("Bravo vous avez deviné " +motOriginal);
            IHM.start();
        }
//        else {
//            System.out.println("Réponse : " + new String(motMasque));
//        }

        return motMasque;
    }



}

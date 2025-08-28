/*
 * Description : Refaire le jeu du Yahtzee
 * Auteur : Yoan Fahrni
 * Date : 20.08.2025
 */

import java.util.LinkedList;
import java.util.Scanner;

public class YahtzeeProcedural {

    /**
     * Génère un nombre aléatoire entre 1 et 6 (Imite un lancer de dé)
     *
     * @return le nombre aléatoire génèré
     */
    public static int tirerUnDe() {


        int nombreGenerer;
        nombreGenerer = (int) (Math.random() * 6 + 1);
        return nombreGenerer;

    }

    /**
     * Génère le nombre de fois voulu un nombre aléatoire avec l'aide de la fonction tirerUnDe
     *
     * @return un tableau avec les nombres généré
     */
    public static int[] tirerTousLesDes() {

        //Créer un nouveau tableau
        int[] tireGenerer = new int[5];

        //Ajoute le nombre de lancé voulu dans le tableau
        for (int i = 0; i < tireGenerer.length; i++) {
            tireGenerer[i] = tirerUnDe();
        }

        return tireGenerer;
    }

    /**
     * affiche une liste de nombre
     *
     * @param listeDeDes la liste qu'on veut afficher
     */
    public static void afficherDe(int[] listeDeDes) {

        //affiche les dé un par un
        for (int i = 0; i < listeDeDes.length; i++) {
            System.out.println("Dé " + (i + 1) + " : " + listeDeDes[i]);
        }

    }

    /**
     * Demande a l'utilisateur quelle dé il veut relancer
     *
     * @return une liste des dés que l'utilisateur veut relancer
     */
    public static int[] demanderLesDes() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Relancer les dés (1 - 5) ou quitter (6) \n");
        String ligne = scanner.nextLine();

        // Supprime tous les espaces et crée un liste String avec les chiffres saisies
        String[] valeur = ligne.trim().split("\\s+");

        int[] tableauDes = new int[valeur.length];

        //Transforme les valeurs String en int
        for (int i = 0; i < valeur.length; i++) {

            tableauDes[i] = Integer.parseInt(valeur[i]) - 1;

        }

        return tableauDes;

    }

    /**
     *
     * @param listeDes
     * @return
     */
    public static int[] compterOccurence(int[] listeDes) {

        int[] nbrOccurences = new int[6]; // INDEX 0 = occurence chiffre 1 / INDEX 1 = occurence chiifre 2 / ...

        for (int chiffre : listeDes) {

            nbrOccurences[chiffre - 1]++;

        }

        return nbrOccurences;

    }

    /**
     * relance les dées choisient par l'utilisateur
     *
     * @param listeDesRelancer la liste des dées a relancer
     * @param lesFaces         la liste des face a changer
     */
    public static void relancerLesDesChoisi(int[] listeDesRelancer, int[] lesFaces) {

        // relance les des choisis par l'utilisateur
        for (int i = 0; i < listeDesRelancer.length; i++) {
            lesFaces[listeDesRelancer[i]] = tirerUnDe();
        }
    }

    public static boolean laPaire(int[] listeDes) {

        boolean paire = false;
        int[] occurences = compterOccurence(listeDes);
        for (int occurence : occurences) {
            if (occurence >= 2) {
                paire = true;
            }
        }
        return paire;

    }

    public static boolean doublePaire(int[] listeDes) {

        boolean doublePaire = false;
        int[] occurences = compterOccurence(listeDes);

        for (int i = 0; i < 6; i++) {
            if (occurences[i] >= 2) {
                for (int j = i + 1; j < 6; j++) {
                    if (occurences[j] >= 2) {
                        doublePaire = true;
                    }
                }
            }
        }

        return doublePaire;
    }

    public static boolean brelan(int[] listeDes) {

        boolean brelan = false;

        int[] occurences = compterOccurence(listeDes);
        for (int occurence : occurences) {
            if (occurence >= 3) {
                brelan = true;
            }
        }
        return brelan;

    }

    public static boolean carre(int[] listeDes) {

        boolean carre = false;

        int[] occurences = compterOccurence(listeDes);
        for (int occurence : occurences) {
            if (occurence >= 4) {
                carre = true;
            }
        }
        return carre;

    }

    public static boolean yahtzee(int[] listeDes) {

        boolean yahtzee = false;

        int[] occurences = compterOccurence(listeDes);
        for (int occurence : occurences) {
            if (occurence >= 5) {
                yahtzee = true;
            }
        }
        return yahtzee;

    }

    public static boolean petiteSuite(int[] listeDes) {
        boolean petiteSuite = false;
        int[] occurences = compterOccurence(listeDes);

        if (occurences[0] >= 1 && occurences[1] >= 1 && occurences[2] >= 1 && occurences[3] >= 1) {
            petiteSuite = true;
        }

        if (occurences[1] >= 1 && occurences[2] >= 1 && occurences[3] >= 1 && occurences[4] >= 1) {
            petiteSuite = true;
        }

        if (occurences[2] >= 1 && occurences[3] >= 1 && occurences[4] >= 1 && occurences[5] >= 1) {
            petiteSuite = true;
        }

        return petiteSuite;

    }

    public static boolean grandeSuite(int[] listeDes) {
        boolean grandeSuite = false;
        int[] occurences = compterOccurence(listeDes);

        if (occurences[0] >= 1 && occurences[1] >= 1 && occurences[2] >= 1 && occurences[3] >= 1 && occurences[4] >= 1) {
            grandeSuite = true;
        }

        if (occurences[1] >= 1 && occurences[2] >= 1 && occurences[3] >= 1 && occurences[4] >= 1 && occurences[5] >= 1) {
            grandeSuite = true;
        }

        return grandeSuite;

    }

    public static boolean fullHouse(int[] listeDes) {
        boolean fullHouse = false;
        int[] occurences = compterOccurence(listeDes);

        for (int i = 0; i < 6; i++) {
            if (occurences[i] >= 2) {
                for (int j = i + 1; j < 6; j++) {
                    if (occurences[j] >= 3) {
                        fullHouse = true;
                    }
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            if (occurences[i] >= 3) {
                for (int j = i + 1; j < 6; j++) {
                    if (occurences[j] >= 2) {
                        fullHouse = true;
                    }
                }
            }
        }

        return fullHouse;
    }

    public static void main(String[] args) {

        int[] lesFaces = new int[5];

        lesFaces[0] = 2;
        lesFaces[1] = 2;
        lesFaces[2] = 2;
        lesFaces[3] = 2;
        lesFaces[4] = 1;

        afficherDe(lesFaces);

        int compteur = 0;
        int[] listeDesRelancer;
        boolean arreterParUtilisateur = false;

        // Permet 2 relance ou de quitter si l'utilisateur saisie 6
        do {

            listeDesRelancer = demanderLesDes();

            if (listeDesRelancer[0] == 5) {

                arreterParUtilisateur = true;

            } else {

                relancerLesDesChoisi(listeDesRelancer, lesFaces);

                afficherDe(lesFaces);

                compteur++;

            }

        } while (compteur < 2 && !arreterParUtilisateur);

        int[] occurences = compterOccurence(lesFaces);

        for (int i = 0; i < 6; i++) {
            System.out.println("Nombre de fois le chiffre " + (i + 1) + " : " + occurences[i]);
        }

        System.out.print("Une paire : ");
        if (laPaire(lesFaces)) {
            System.out.println("5 pts");
        } else {
            System.out.println("0 pts");
        }

        System.out.print("Une double paire : ");
        if (doublePaire(lesFaces)) {
            System.out.println("10 pts");
        } else {
            System.out.println("0 pts");
        }

        System.out.print("Un brelan : ");
        if (brelan(lesFaces)) {
            System.out.println("TODO");
        } else {
            System.out.println("0 pts");
        }

        System.out.print("Un carré : ");
        if (carre(lesFaces)) {
            System.out.println("TODO");
        } else {
            System.out.println("0 pts");
        }

        System.out.print("Un yathzee : ");
        if (yahtzee(lesFaces)) {
            System.out.println("50 pts");
        } else {
            System.out.println("0 pts");
        }

        System.out.print("petite suite : ");
        if (petiteSuite(lesFaces)) {
            System.out.println("30 pts");
        } else {
            System.out.println("0 pts");
        }

        System.out.print("grande suite : ");
        if (grandeSuite(lesFaces)) {
            System.out.println("40 pts");
        } else {
            System.out.println("0 pts");
        }

        System.out.print("full house : ");
        if (fullHouse(lesFaces)) {
            System.out.println("25 pts");
        } else {
            System.out.println("0 pts");
        }

    }
}

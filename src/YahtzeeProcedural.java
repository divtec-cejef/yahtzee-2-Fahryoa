/*
 * Description : Refaire le jeu du Yahtzee
 * Auteur : Yoan Fahrni ☻
 * Date : 20.08.2025
 */

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

    /**
     * Compte le nombre d'occurence dans une liste de dés
     *
     * @param listeDes la liste des dés dont l'on veut compter les occurences
     * @return avec les occurences (INDEX 0 = occurence chiffre 1 / INDEX 1 = occurence chiifre 2 / ...)
     */
    public static int[] compterOccurence(int[] listeDes) {

        int[] nbrOccurences = new int[6]; // INDEX 0 = occurence chiffre 1 / INDEX 1 = occurence chiifre 2 / ...

        for (int chiffre : listeDes) {

            nbrOccurences[chiffre - 1]++;

        }

        return nbrOccurences;

    }

    /**
     * regarde s'il y a une paire dans une liste de dés
     *
     * @param listeDes la liste des dés dont l'on veut savoir s'il y a une paire
     * @return une boolean vrai si il y a une paire false sinon
     */
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

    /**
     * regarde s'il y a deux paire différentes dans un jet de dés
     *
     * @param listeDes la liste des dés dont l'on veut savoir s'il y a une double paire
     * @return une boolean vrai si il y a une double paire false sinon
     */
    public static boolean doublePaire(int[] listeDes) {

        boolean doublePaire = false;
        int nbrPaire = 0;
        int[] occurences = compterOccurence(listeDes);

        for (int i = 0; i < 6; i++) {
            if (occurences[i] >= 2) {
                nbrPaire++;
            }
        }

        return nbrPaire >= 2;
    }

    /**
     * regarde s'il y a un brelan dans un jet de dés
     *
     * @param listeDes la liste des dés dont l'on veut savoir s'il y a un brelan
     * @return une boolean vrai si il y a un brelan false sinon
     */
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

    /**
     * regarde s'il y a un carré dans un jet de dés
     *
     * @param listeDes la liste des dés dont l'on veut savoir s'il y a un carré
     * @return une boolean vrai si il y a un carré false sinon
     */
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

    /**
     * regarde s'il y a un full house dans un jet de dés
     *
     * @param listeDes la liste des dés dont l'on veut savoir s'il y a un full house
     * @return une boolean vrai si il y a un full house false sinon
     */
    public static boolean fullHouse(int[] listeDes) {
        boolean brelan = false;
        boolean paire = false;
        int[] occurences = compterOccurence(listeDes);

        for (int i = 0; i < 6; i++) {
            if (occurences[i] == 2) {
                paire = true;
            }

            if (occurences[i] == 3) {
                brelan = true;
            }
        }

        return brelan && paire;
    }

    /**
     * regarde s'il y a une petite suite dans un jet de dés
     *
     * @param listeDes la liste des dés dont l'on veut savoir s'il y a une petite suite
     * @return une boolean vrai si il y a une petite suite false sinon
     */
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

    /**
     * regarde s'il y a une grande suite dans un jet de dés
     *
     * @param listeDes la liste des dés dont l'on veut savoir s'il y a une grande suite
     * @return une boolean vrai si il y a une grande suite false sinon
     */
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

    /**
     * regarde s'il y a un yahtzee dans un jet de dés
     *
     * @param listeDes la liste des dés dont l'on veut savoir s'il y a un yathzee
     * @return une boolean vrai si il y a un yathzee false sinon
     */
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

    /**
     * Calcule le nombre de points par combinaison
     *
     * @param listeDes la liste des dés
     * @return un liste avec les différents points
     */
    public static int[] lesPoints(int[] listeDes, String[] listeCombinaison) {
        int[] lesPoints = new int[listeCombinaison.length];

        if (laPaire(listeDes) && !listeCombinaison[0].isEmpty()) {
            lesPoints[0] = 5;
        }

        if (doublePaire(listeDes) && !listeCombinaison[1].isEmpty()) {
            lesPoints[1] = 10;
        }

        if (brelan(listeDes) && !listeCombinaison[2].isEmpty()) {
            int points = 0;

            for (int i = 0; i < 6; i++) {
                if (compterOccurence(listeDes)[i] >= 3) {
                    points = 3 * (i + 1);
                }
            }

            lesPoints[2] = points;
        }

        if (carre(listeDes) && !listeCombinaison[3].isEmpty()) {
            int points = 0;

            for (int i = 0; i < 6; i++) {
                if (compterOccurence(listeDes)[i] >= 4) {
                    points = 4 * (i + 1);
                }
            }

            lesPoints[3] = points;
        }

        if (fullHouse(listeDes) && !listeCombinaison[4].isEmpty()) {
            lesPoints[4] = 25;
        }

        if (petiteSuite(listeDes) && !listeCombinaison[5].isEmpty()) {
            lesPoints[5] = 30;
        }

        if (grandeSuite(listeDes) && !listeCombinaison[6].isEmpty()) {
            lesPoints[6] = 40;
        }

        if (yahtzee(listeDes) && !listeCombinaison[7].isEmpty()) {
            lesPoints[7] = 50;
        }

        return lesPoints;
    }

    /**
     * affiche les points des combinaisons
     *
     * @param listeDes la liste des dés
     */
    public static void afficherLesPoints(int[] listeDes, String[] combinaisons, int[] points) {

        for (int i = 0; i < combinaisons.length; i++) {
            if (!combinaisons[i].isEmpty()) {
                System.out.println(combinaisons[i] + " : " + points[i]);
            }
        }
    }

    public static String[] QuestionneCombinaisons(String[] listeCombinaison) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une combinaisons (1 - 8) : ");
        int combinaisonSaisie = scanner.nextInt();

        String[] nouvelleCombinaison = listeCombinaison.clone();

        nouvelleCombinaison[combinaisonSaisie - 1] = "";

        return nouvelleCombinaison;

    }

    public static void main(String[] args) {

        int[] lesFaces = new int[5];
        lesFaces = tirerTousLesDes();

/*
        lesFaces[0] = 2;
        lesFaces[1] = 2;
        lesFaces[2] = 2;
        lesFaces[3] = 2;
        lesFaces[4] = 1;
*/
        afficherDe(lesFaces);

        int compteur = 0;
        int[] listeDesRelancer;
        boolean arreterParUtilisateur = false;
        String[] combinaisons = {
                "1) Paire",
                "2) Double Paire",
                "3) Brelan",
                "4) Carré",
                "5) Full House",
                "6) Petite Suite",
                "7) Grande Suite",
                "8) Yathzee"
        };

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

/*
        for (int i = 0; i < 6; i++) {
            System.out.println("Nombre de fois le chiffre " + (i + 1) + " : " + occurences[i]);
        }
*/
        int[] points = new int[8];
        points = lesPoints(lesFaces, combinaisons);

        afficherLesPoints(lesFaces, combinaisons, points);

        String[] nouvelleCombinaisons = QuestionneCombinaisons(combinaisons);

        int[] points2 = new int[8];

        points2 = lesPoints(lesFaces, nouvelleCombinaisons);

        afficherLesPoints(lesFaces, nouvelleCombinaisons, points2);

    }
}

// variable = condition ? true : false

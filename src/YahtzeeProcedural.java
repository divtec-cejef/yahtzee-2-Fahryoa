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
     * @return le nombre aléatoire génèré
     */
    public static int tirerUnDe() {


        int nombreGenerer;
        nombreGenerer = (int) (Math.random() * 6 + 1);
        return nombreGenerer;

    }

    /**
     * Génère le nombre de fois voulu un nombre aléatoire avec l'aide de la fonction tirerUnDe
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
     * @return une liste des dés que l'utilisateur veut relancer
     */
    public static int[] relancerLesDes() {

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
     * @param chiffreACompter
     * @return
     */
    public static int compterOccurence(int[] listeDes, int chiffreACompter) {

        int nbrOccurences = 0;

        for (int i = 0; i < 5; i++) {
           if (listeDes[i] ==  chiffreACompter) {
               nbrOccurences++;
           }
        }

        return nbrOccurences;

    }

    /**
     * relance les dées choisient par l'utilisateur
     * @param listeDesRelancer la liste des dées a relancer
     * @param lesFaces la liste des face a changer
     */
    public static void relancerLesDesChoisi(int[] listeDesRelancer, int[] lesFaces) {

        // relance les des choisis par l'utilisateur
        for (int i = 0; i < listeDesRelancer.length; i++) {
            if (listeDesRelancer[i] < 5 && listeDesRelancer[i] >= 0) {
                lesFaces[listeDesRelancer[i]] = tirerUnDe();
            }
        }
    }

    public static void main(String[] args) {

        int[] lesFaces = new int[5];

        lesFaces = tirerTousLesDes();

        afficherDe(lesFaces);

        int compteur = 0;
        int[] listeDesRelancer;
        boolean arreterParUtilisateur = false;

        // Permet 2 relance ou de quitter si aucun dés n'est relancer
        do {

            listeDesRelancer = relancerLesDes();

            relancerLesDesChoisi(listeDesRelancer, lesFaces);

            afficherDe(lesFaces);

            compteur++;

            for  (int faces : listeDesRelancer) {
                if (faces == 6) {
                    arreterParUtilisateur = true;
                }
            }

        } while (compteur < 2 && !arreterParUtilisateur);
    }
}

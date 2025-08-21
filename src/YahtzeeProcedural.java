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

        int[] tableauDes = new int[5];

        for (int i = 0; i < 5; i++) {
            tableauDes[i] = 5;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Quels dés relancer ? (1 - 5) \n");
        String ligne = scanner.nextLine();

        // Supprime tous les espaces et crée un liste String avec les chiffres saisies
        String[] token = ligne.trim().split("\\s+");

        LinkedList<Integer> listeDes = new LinkedList<Integer>();

        //Transforme les valeurs String en int
        for (String tokens : token) {
            switch (tokens) {
                case "1":listeDes.add(0);break;
                case "2":listeDes.add(1);break;
                case "3":listeDes.add(2);break;
                case "4":listeDes.add(3);break;
                case "5":listeDes.add(4);break;
            }
        }

        boolean un = false;
        boolean deux = false;
        boolean trois = false;
        boolean quatre = false;
        boolean cinq = false;

        for (int i = 0; i < listeDes.size(); i++) {

            if ((-1 < listeDes.get(i) || listeDes.get(i) > 5) && un && deux && trois && quatre && cinq) {
                listeDes.remove(i);
            } else {
                switch (listeDes.get(i)) {
                    case 0: un = true; break;
                    case 1: deux = true; break;
                    case 2: trois = true; break;
                    case 3: cinq = true; break;
                    case 4: quatre = true; break;
                }
            }

        }

        for (int i = 0; i < listeDes.size(); i++) {
            tableauDes[i] = listeDes.get(i);
        }

        return tableauDes;

    }

    public static void main(String[] args) {

        int[] lesFaces = new int[5];
        int[] listeDesRelancer = new int[5];

        lesFaces = tirerTousLesDes();

        afficherDe(lesFaces);

        // Permet 2 relance
        for (int j = 0; j < 2; j++) {

            listeDesRelancer =  relancerLesDes();

            // relance les des choisis par l'utilisateur
            for (int i = 0; i < listeDesRelancer.length; i++) {
               if (listeDesRelancer[i] != 5) {
                    lesFaces[listeDesRelancer[i]] = tirerUnDe();
               }
            }

            afficherDe(lesFaces);
        }
    }

}

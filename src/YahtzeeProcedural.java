/*
 * Description : Refaire le jeu du Yahtzee
 * Auteur : Yoan Fahrni
 * Date : 20.08.2025
 */
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
    public static int[] nbreDe() {

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

    public static void main(String[] args) {

        int[] lesFaces = new int[5];

        lesFaces = nbreDe();

        afficherDe(lesFaces);

    }

}

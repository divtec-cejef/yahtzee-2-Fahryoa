package objet;
import java.util.Scanner;

public class ConsoleIO {

    /**
     * Affiche du texte dans la console
     * @param text le texte a affiché
     */
    public void afficherDuText(String text) {
        System.out.println(text);
    }

    /**
     * Afficher la main d'un joueur dans la console
     * @param laMain la main que l'on veut afficher
     */
    public void afficherUneMain(DiceHand laMain) {
        for(int i = 0; i < laMain.getLesDes().length; i++) {
            System.out.println("Dé " + (i + 1) + " : " + laMain.getLesDes()[i].getFaceExpose());
        }
    }

    public int[] demanderDesRelancer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Relancer les dés (1 - 5) ou quitter (7) \n");
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

    public void afficherCombinaison(DiceHand laMain, int[] combinaisonsAAfficher) {
        for(int i = 0; i < combinaisonsAAfficher.length; i++) {
            if(combinaisonsAAfficher[i] > 0) {
            System.out.println(Category.values()[combinaisonsAAfficher[i] - 1].getNomCategorie() + " : "
                    + Category.values()[combinaisonsAAfficher[i] - 1].score(laMain));
            }
        }
    }

    public int demanderComabinaisons() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void afficherUnScore(int pointTotal) {
        System.out.println("Les points total : " + pointTotal);
    }
}

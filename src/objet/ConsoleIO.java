package objet;
import java.util.Scanner;

public class ConsoleIO {

    /**
     * Affiche du texte dans la console
     * @param text le texte a affiché
     */
    public void AfficherDuText(String text) {
        System.out.println(text);
    }

    /**
     * Afficher la main d'un joueur dans la console
     * @param laMain la main que l'on veut afficher
     */
    public void AfficherUneMain(DiceHand laMain) {
        for(int i = 0; i < laMain.getLesDes().length; i++) {
            System.out.println("Dé " + (i + 1) + " : " + laMain.getLesDes()[i].getFaceExpose());
        }
    }

}

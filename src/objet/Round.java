package objet;

public class Round {

    public int uneManche(Player joueur, ConsoleIO console, int[] combinaisons) {
        joueur.getDiceHand().relancerTousLesDes();
        for (int i = 0; i < 2; i++) {
            console.afficherUneMain(joueur.getDiceHand());
            int[] deRelancer = console.demanderDesRelancer();
            if (deRelancer[i] > 5) {
                break;
            } else {
                joueur.getDiceHand().relanceLesDes(deRelancer);
            }
        }
        console.afficherCombinaison(joueur.getDiceHand(), combinaisons);
        return Category.values()[console.demanderComabinaisons()].score(joueur.getDiceHand());
    }
}

/*
 * 1 manche :
 * 1) tu lance tout les dés (5)
 * 2) tu relance les dés choisi
 * 3) tu relance une nouvelle fois
 * 4) tu choisi la combinaison
 */

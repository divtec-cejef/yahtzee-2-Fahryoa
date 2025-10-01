package objet;

public class Round {

    public ScoreEntry uneManche(Player joueur, ConsoleIO console, int[] combinaisons) {
        joueur.getDiceHand().relancerTousLesDes();
        for (int i = 0; i < 2; i++) {
            console.afficherUneMain(joueur.getDiceHand());
            int[] deRelancer = console.demanderDesRelancer();
            if (deRelancer[0] >= 6) {
                break;
            } else {
                joueur.getDiceHand().relanceLesDes(deRelancer);
            }
        }
        console.afficherUneMain(joueur.getDiceHand());
        console.afficherCombinaison(joueur.getDiceHand(), combinaisons);
        int combinaisonChoisie = console.demanderComabinaisons();
        combinaisons[combinaisonChoisie - 1] = 0;
        return new ScoreEntry(Category.PAIRE.TransformeIntEnCategory(combinaisonChoisie), Category.PAIRE.TransformeIntEnCategory(combinaisonChoisie).score(joueur.getDiceHand()));
    }
}

/*
 * 1 manche :
 * 1) tu lance tout les dés (5)
 * 2) tu relance les dés choisi
 * 3) tu relance une nouvelle fois
 * 4) tu choisi la combinaison
*/

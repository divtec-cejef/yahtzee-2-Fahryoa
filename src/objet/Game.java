package objet;

public class Game {
    private Player joueur;
    private Round manche = new Round();

    public void UnePartie(ConsoleIO console) {
        int[] combinaisons = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        DiceHand hand = new DiceHand(5);
        joueur = new Player(hand);
        ScoreEntry[] listeScore = new ScoreEntry[5];
        for(int i = 0; i < 5; i++) {
            listeScore[i] = manche.uneManche(joueur, console, combinaisons);
        }
        ScoreCard lesScores = new ScoreCard(listeScore);
        console.afficherUnScore(lesScores.compterPointTotal());
    }

}

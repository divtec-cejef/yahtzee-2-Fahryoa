package objet;

public class ScoreEntry {

    private Category combinaisons;
    private int points;
    private DiceHand jetFinal;

    public ScoreEntry(Category combinaisons, int points, DiceHand jetFinal) {
        this.combinaisons = combinaisons;
        this.points = 0;
    }

    public int getScore() {
        return points;
    }

    public Category getCombinaisons() {
        return combinaisons;
    }

}

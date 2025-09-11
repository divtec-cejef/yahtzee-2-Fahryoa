package objet;

public class ScoreEntry {

    private Category combinaisons;
    private int score;

    public ScoreEntry(Category combinaisons) {
        this.combinaisons = combinaisons;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public Category getCombinaisons() {
        return combinaisons;
    }

}

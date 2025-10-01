package objet;

public class ScoreEntry {

    private Category combinaisons;
    private int points = 0;

    public ScoreEntry(Category combinaisons, int points) {
        this.combinaisons = combinaisons;
            this.points = points;
    }

    public int getScore() {
        return this.points;
    }

    public Category getCombinaisons() {
        return combinaisons;
    }

}

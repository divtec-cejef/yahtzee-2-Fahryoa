package objet;

public class ScoreCard {
    private ScoreEntry[] lesScore;

    public ScoreCard(ScoreEntry[] lesScore) {
        this.lesScore = lesScore;
    }

    public int compterPointTotal() {
        int pointsTotal = 0;
        for (int i = 0; i < lesScore.length; i++) {
            pointsTotal += lesScore[i].getScore();
        }
        return pointsTotal;
    }

    public void setLesScore(ScoreEntry[] lesScore) {
        this.lesScore = lesScore;
    }
}
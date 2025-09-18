package objet;

public class ScoreCard {
    private int pointsTotal;
    private ScoreEntry[] lesScore;

    public ScoreCard(ScoreEntry[] lesScore) {
        this.lesScore = lesScore;
    }

    public void compterPointTotal() {
        pointsTotal = 0;
        for (int i = 0; i < lesScore.length; i++) {
            pointsTotal += lesScore[i].getScore();
        }
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public void setLesScore(ScoreEntry[] lesScore) {
        this.lesScore = lesScore;
    }
}
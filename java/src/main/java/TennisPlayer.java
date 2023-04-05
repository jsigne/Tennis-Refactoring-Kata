public class TennisPlayer {
    private final String name;
    private int score;

    public TennisPlayer(String name) {
        this.name = name;
        this.score = 0;
    }

    public int score() {
        return score;
    }

    public void addOneToScore() {
        score += 1;
    }

    public boolean isScoreEqualTo(TennisPlayer opponent) {
        return score == opponent.score();
    }

    public String scoreToString() {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };
    }

    public boolean isPlayerAbleToWin() {
        return score >= 4;
    }

}

public class TennisPlayer2 {
    private final String name;

    private int score;

    public TennisPlayer2(String name) {
        this.name = name;
        this.score = 0;
    }

    public int score() {
        return score;
    }

    public void winPoint(){
        score++;
    }

    public boolean isScoreEqualTo(TennisPlayer2 player2) {
        return score == player2.score();
    }
}

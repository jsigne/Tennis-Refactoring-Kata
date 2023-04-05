public class Player {
    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public int score() {
        return score;
    }

    public void addOneToScore() {
        score += 1;
    }

    public StringBuilder scoreAsStringBuilder() {
        return switch (score) {
            case 0 -> new StringBuilder("Love-All");
            case 1 -> new StringBuilder("Fifteen-All");
            case 2 -> new StringBuilder("Thirty-All");
            default -> new StringBuilder("Deuce");
        };
    }

    private StringBuilder getScoreAdvantageStringBuilder(Player player2) {
        StringBuilder score;
        int minusResult = this.score()-player2.score();
        if (minusResult==1) score = new StringBuilder("Advantage player1");
        else if (minusResult ==-1) score = new StringBuilder("Advantage player2");
        else if (minusResult>=2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

}

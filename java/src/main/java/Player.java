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



}

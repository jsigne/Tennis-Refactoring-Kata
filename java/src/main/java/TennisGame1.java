
public class TennisGame1 implements TennisGame {
    private final TennisPlayer tennisPlayer1;
    private final TennisPlayer tennisPlayer2;

    public TennisGame1(String player1Name, String player2Name) {
        tennisPlayer1 = new TennisPlayer(player1Name);
        tennisPlayer2 = new TennisPlayer(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            tennisPlayer1.addOneToScore();
        else
            tennisPlayer2.addOneToScore();
    }

    public String getScore() {
        if (tennisPlayer1.isScoreEqualTo(tennisPlayer2))
        {
            return scoreToStringIfEquality(tennisPlayer1.score());
        }
        if (tennisPlayer1.isPlayerAbleToWin() || tennisPlayer2.isPlayerAbleToWin())
        {
            return getScoreAdvantageOrWin();
        }
        else
        {
            return tennisPlayer1.scoreToString() + "-" + tennisPlayer2.scoreToString();
        }
    }

    private String getScoreAdvantageOrWin() {
        int scoreDifferenceForPlayer1 = tennisPlayer1.score() - tennisPlayer2.score();
        if (scoreDifferenceForPlayer1 == 1) return "Advantage player1";
        else if (scoreDifferenceForPlayer1 == -1) return "Advantage player2";
        else if (scoreDifferenceForPlayer1 >= 2) return "Win for player1";
        return "Win for player2";
    }

    public String scoreToStringIfEquality(int gameScore) {
        return switch (gameScore) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}

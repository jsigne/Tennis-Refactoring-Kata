
public class TennisGame1 implements TennisGame {
    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1.addOneToScore();
        else
            player2.addOneToScore();
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore = 0;
        if (player1.score() == player2.score())
        {
            return player1.scoreAsStringBuilder().toString();
        }
        if (player1.score()>=4 || player2.score()>=4)
        {
            return getScoreAdvantageStringBuilder().toString();
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1.score();
                else { score.append("-"); tempScore = player2.score();}
                switch (tempScore) {
                    case 0 -> score.append("Love");
                    case 1 -> score.append("Fifteen");
                    case 2 -> score.append("Thirty");
                    case 3 -> score.append("Forty");
                }
            }
        }
        return score.toString();
    }

    private StringBuilder getScoreAdvantageStringBuilder() {
        StringBuilder score;
        int minusResult = player1.score()-player2.score();
        if (minusResult==1) score = new StringBuilder("Advantage player1");
        else if (minusResult ==-1) score = new StringBuilder("Advantage player2");
        else if (minusResult>=2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }
}

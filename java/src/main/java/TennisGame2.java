import java.util.Objects;

public class TennisGame2 implements TennisGame
{
    private String P1res = "";
    private String P2res = "";

    private final TennisPlayer2 tennisPlayer1;
    private final TennisPlayer2 tennisPlayer2;

    public TennisGame2(String player1Name, String player2Name) {
        tennisPlayer1 = new TennisPlayer2(player1Name);
        tennisPlayer2 = new TennisPlayer2(player2Name);
    }

    public String getScore(){
        String score = "";
        if (tennisPlayer1.isScoreEqualTo(tennisPlayer2))
        {
            return WriteScoreWhenEquality();
        }
        
        if (tennisPlayer1.score() > 0 && tennisPlayer2.score()==0)
        {
            if (tennisPlayer1.score()==1)
                P1res = "Fifteen";
            if (tennisPlayer1.score()==2)
                P1res = "Thirty";
            if (tennisPlayer1.score()==3)
                P1res = "Forty";
            
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (tennisPlayer2.score() > 0 && tennisPlayer1.score()==0)
        {
            if (tennisPlayer2.score()==1)
                P2res = "Fifteen";
            if (tennisPlayer2.score()==2)
                P2res = "Thirty";
            if (tennisPlayer2.score()==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (tennisPlayer1.score()>tennisPlayer2.score() && tennisPlayer1.score() < 4)
        {
            if (tennisPlayer1.score()==2)
                P1res="Thirty";
            if (tennisPlayer1.score()==3)
                P1res="Forty";
            if (tennisPlayer2.score()==1)
                P2res="Fifteen";
            if (tennisPlayer2.score()==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (tennisPlayer2.score()>tennisPlayer1.score() && tennisPlayer2.score() < 4)
        {
            if (tennisPlayer2.score()==2)
                P2res="Thirty";
            if (tennisPlayer2.score()==3)
                P2res="Forty";
            if (tennisPlayer1.score()==1)
                P1res="Fifteen";
            if (tennisPlayer1.score()==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        if (tennisPlayer1.score() > tennisPlayer2.score() && tennisPlayer2.score() >= 3)
        {
            score = "Advantage player1";
        }
        
        if (tennisPlayer2.score() > tennisPlayer1.score() && tennisPlayer1.score() >= 3)
        {
            score = "Advantage player2";
        }
        
        if (tennisPlayer1.score()>=4 && tennisPlayer2.score()>=0 && (tennisPlayer1.score()-tennisPlayer2.score())>=2)
        {
            score = "Win for player1";
        }
        if (tennisPlayer2.score()>=4 && tennisPlayer1.score()>=0 && (tennisPlayer2.score()-tennisPlayer1.score())>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String WriteScoreWhenEquality() {
        return switch(tennisPlayer1.score()) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, "player1"))
            tennisPlayer1.winPoint();
        else
            tennisPlayer2.winPoint();
    }
}
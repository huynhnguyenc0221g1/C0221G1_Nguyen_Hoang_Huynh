package ss08_clean_code.bai_tap.refactoring;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        StringBuilder score = new StringBuilder();
        int currentScore = 0;
        boolean equalScore = player1Score == player2Score;
        if (equalScore) {
            score = callEqualScore(player1Score);
        } else {
            boolean deuce = player1Score >= 4 || player2Score >= 4;
            if (deuce) {
                score = callAdvantageScore(player1Score, player2Score);
            } else {
                for (int wonPoint = 1; wonPoint < 3; wonPoint++) {
                    if (wonPoint == 1) currentScore = player1Score;
                    else {
                        score.append("-");
                        currentScore = player2Score;
                    }
                    callScore(score, currentScore);
                }
            }
        }
        return score.toString();
    }

    private static void callScore(StringBuilder score, int tempScore) {
        switch (tempScore) {
            case 0:
                score.append("Love");
                break;
            case 1:
                score.append("Fifteen");
                break;
            case 2:
                score.append("Thirty");
                break;
            case 3:
                score.append("Forty");
                break;
        }
    }

    private static StringBuilder callAdvantageScore(int player1Score, int player2Score) {
        StringBuilder score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private static StringBuilder callEqualScore(int player1Score) {
        StringBuilder score;
        switch (player1Score) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            case 3:
                score = new StringBuilder("Forty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;

        }
        return score;
    }
}

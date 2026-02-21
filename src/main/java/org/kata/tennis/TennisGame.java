package org.kata.tennis;

public class TennisGame {
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    public void playerOneScores() {
        playerOnePoints++;
    }

    public void playerTwoScores() {
        playerTwoPoints++;
    }

    public String getScore() {
        return pointName(playerOnePoints) + "-" + pointName(playerTwoPoints);
    }

    private String pointName(int points) {
        return switch (points) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalStateException("Unexpected points: " + points);
        };
    }
}

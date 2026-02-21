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

        // Caso especial inicial
        if (playerOnePoints == 0 && playerTwoPoints == 0) {
            return "Love-Love";
        }

        // Empates antes de 40
        if (playerOnePoints == playerTwoPoints && playerOnePoints < 3) {
            return pointName(playerOnePoints) + "-All";
        }

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

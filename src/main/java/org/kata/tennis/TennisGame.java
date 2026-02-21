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

        int diff = playerOnePoints - playerTwoPoints;

        // Victoria
        if (playerOnePoints >= 4 || playerTwoPoints >= 4) {
            if (diff >= 2) return "Player 1 wins";
            if (diff <= -2) return "Player 2 wins";
        }

        // Deuce / Advantage
        if (playerOnePoints >= 3 && playerTwoPoints >= 3) {
            if (diff == 0) return "Deuce";
            if (diff == 1) return "Advantage Player 1";
            if (diff == -1) return "Advantage Player 2";
        }

        // Caso especial inicial
        if (playerOnePoints == 0 && playerTwoPoints == 0) {
            return "Love-Love";
        }

        // Empates antes de 40
        if (playerOnePoints == playerTwoPoints) {
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

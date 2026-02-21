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

        if (isStart()) {
            return "Love-Love";
        }

        if (isWin()) {
            return getWinner();
        }

        if (isDeuce()) {
            return "Deuce";
        }

        if (isAdvantage()) {
            return getAdvantagePlayer();
        }

        if (isTie()) {
            return pointName(playerOnePoints) + "-All";
        }

        return pointName(playerOnePoints) + "-" + pointName(playerTwoPoints);
    }

    private boolean isStart() {
        return playerOnePoints == 0 && playerTwoPoints == 0;
    }

    private boolean isWin() {
        return (playerOnePoints >= 4 || playerTwoPoints >= 4)
                && Math.abs(playerOnePoints - playerTwoPoints) >= 2;
    }

    private String getWinner() {
        return playerOnePoints > playerTwoPoints
                ? "Player 1 wins"
                : "Player 2 wins";
    }

    private boolean isDeuce() {
        return playerOnePoints >= 3
                && playerTwoPoints >= 3
                && playerOnePoints == playerTwoPoints;
    }

    private boolean isAdvantage() {
        return playerOnePoints >= 3
                && playerTwoPoints >= 3
                && Math.abs(playerOnePoints - playerTwoPoints) == 1;
    }

    private String getAdvantagePlayer() {
        return playerOnePoints > playerTwoPoints
                ? "Advantage Player 1"
                : "Advantage Player 2";
    }

    private boolean isTie() {
        return playerOnePoints == playerTwoPoints
                && playerOnePoints > 0
                && playerOnePoints < 3;
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
package org.kata.tennis;

public class TieBreakGame implements GameStrategy {

    private static final int MIN_POINTS_TO_WIN = 7;

    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    @Override
    public void playerOneScores() {
        playerOnePoints++;
    }

    @Override
    public void playerTwoScores() {
        playerTwoPoints++;
    }

    @Override
    public boolean isFinished() {
        return (playerOnePoints >= MIN_POINTS_TO_WIN
                || playerTwoPoints >= MIN_POINTS_TO_WIN)
                && Math.abs(playerOnePoints - playerTwoPoints) >= 2;
    }

    @Override
    public String getWinner() {
        if (!isFinished()) return null;

        return playerOnePoints > playerTwoPoints
                ? "Player 1"
                : "Player 2";
    }
}
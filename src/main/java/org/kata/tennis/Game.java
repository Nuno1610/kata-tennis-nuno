package org.kata.tennis;

public class Game implements GameStrategy {

    private static final int MIN_POINTS_TO_WIN = 4;
    private static final int MIN_POINTS_FOR_DEUCE = 3;

    private final Player playerOne = new Player("Player 1");
    private final Player playerTwo = new Player("Player 2");

    // =========================
    // Implementación Strategy
    // =========================

    @Override
    public void playerOneScores() {
        playerOne.score();
    }

    @Override
    public void playerTwoScores() {
        playerTwo.score();
    }

    @Override
    public boolean isFinished() {
        return hasWinner();
    }

    @Override
    public String getWinner() {
        if (!hasWinner()) return null;
        return leadingPlayer().getName();
    }

    // =========================
    // Representación opcional
    // =========================

    public String getScore() {

        if (hasWinner()) {
            return getWinner() + " wins";
        }

        if (isDeuce()) {
            return "Deuce";
        }

        if (isAdvantage()) {
            return "Advantage " + leadingPlayer().getName();
        }

        if (isTieBelowDeuce()) {
            return pointName(pointsOne()) + "-All";
        }

        return pointName(pointsOne()) + "-" + pointName(pointsTwo());
    }

    // =========================
    // Lógica interna
    // =========================

    private int pointsOne() {
        return playerOne.getPoints();
    }

    private int pointsTwo() {
        return playerTwo.getPoints();
    }

    private int pointDifference() {
        return pointsOne() - pointsTwo();
    }

    private boolean hasWinner() {
        return (pointsOne() >= MIN_POINTS_TO_WIN || pointsTwo() >= MIN_POINTS_TO_WIN)
                && Math.abs(pointDifference()) >= 2;
    }

    private boolean isDeuce() {
        return pointsOne() >= MIN_POINTS_FOR_DEUCE
                && pointsTwo() >= MIN_POINTS_FOR_DEUCE
                && pointDifference() == 0;
    }

    private boolean isAdvantage() {
        return pointsOne() >= MIN_POINTS_FOR_DEUCE
                && pointsTwo() >= MIN_POINTS_FOR_DEUCE
                && Math.abs(pointDifference()) == 1;
    }

    private boolean isTieBelowDeuce() {
        return pointsOne() == pointsTwo()
                && pointsOne() > 0
                && pointsOne() < MIN_POINTS_FOR_DEUCE;
    }

    private Player leadingPlayer() {
        return pointDifference() > 0 ? playerOne : playerTwo;
    }

    private String pointName(int points) {
        return switch (points) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "Forty";
        };
    }
}
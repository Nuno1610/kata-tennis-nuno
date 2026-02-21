package org.kata.tennis;

public class Game {

    private final Player playerOne = new Player("Player 1");
    private final Player playerTwo = new Player("Player 2");

    public void playerOneScores() {
        playerOne.score();
    }

    public void playerTwoScores() {
        playerTwo.score();
    }

    public String getScore() {

        if (isWin()) return getWinner();

        if (isDeuce()) return "Deuce";

        if (isAdvantage()) return getAdvantagePlayer();

        if (isTie()) return pointName(playerOne.getPoints()) + "-All";

        if (isStart()) return "Love-Love";

        return pointName(playerOne.getPoints()) + "-"
                + pointName(playerTwo.getPoints());
    }

    private boolean isStart() {
        return playerOne.getPoints() == 0 && playerTwo.getPoints() == 0;
    }

    private boolean isWin() {
        return (playerOne.getPoints() >= 4 || playerTwo.getPoints() >= 4)
                && Math.abs(playerOne.getPoints() - playerTwo.getPoints()) >= 2;
    }

    private String getWinner() {
        return playerOne.getPoints() > playerTwo.getPoints()
                ? playerOne.getName() + " wins"
                : playerTwo.getName() + " wins";
    }

    private boolean isDeuce() {
        return playerOne.getPoints() >= 3
                && playerTwo.getPoints() >= 3
                && playerOne.getPoints() == playerTwo.getPoints();
    }

    private boolean isAdvantage() {
        return playerOne.getPoints() >= 3
                && playerTwo.getPoints() >= 3
                && Math.abs(playerOne.getPoints() - playerTwo.getPoints()) == 1;
    }

    private String getAdvantagePlayer() {
        return playerOne.getPoints() > playerTwo.getPoints()
                ? "Advantage " + playerOne.getName()
                : "Advantage " + playerTwo.getName();
    }

    private boolean isTie() {
        return playerOne.getPoints() == playerTwo.getPoints()
                && playerOne.getPoints() > 0
                && playerOne.getPoints() < 3;
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
package org.kata.tennis;

public class TennisSet {

    private int playerOneGames = 0;
    private int playerTwoGames = 0;

    public void playerOneWinsGame() {
        playerOneGames++;
    }

    public void playerTwoWinsGame() {
        playerTwoGames++;
    }

    public String getScore() {
        return playerOneGames + "-" + playerTwoGames;
    }

    public boolean isFinished() {
        return (playerOneGames >= 6 || playerTwoGames >= 6)
                && Math.abs(playerOneGames - playerTwoGames) >= 2;
    }

    public String getWinner() {
        if (!isFinished()) return null;

        return playerOneGames > playerTwoGames
                ? "Player 1"
                : "Player 2";
    }
}
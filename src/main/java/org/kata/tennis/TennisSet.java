package org.kata.tennis;

public class TennisSet {

    private int playerOneGames = 0;
    private int playerTwoGames = 0;

    public String getScore() {
        return playerOneGames + "-" + playerTwoGames;
    }

    public boolean isFinished() {
        return false;
    }

    public String getWinner() {
        return null;
    }

    public void playerOneWinsGame() {
        playerOneGames++;
    }

    public void playerTwoWinsGame() {
        playerTwoGames++;
    }
}
package org.kata.tennis;

public class TennisSet {

    private int playerOneGames = 0;
    private int playerTwoGames = 0;

    private Game currentGame = new Game();

    public void playerOneScores() {
        if (isFinished()) return;

        currentGame.playerOneScores();
        checkGameFinished();
    }

    public void playerTwoScores() {
        if (isFinished()) return;

        currentGame.playerTwoScores();
        checkGameFinished();
    }

    private void checkGameFinished() {
        String gameScore = currentGame.getScore();

        if ("Player 1 wins".equals(gameScore)) {
            playerOneGames++;
            currentGame = new Game();
        }

        if ("Player 2 wins".equals(gameScore)) {
            playerTwoGames++;
            currentGame = new Game();
        }
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
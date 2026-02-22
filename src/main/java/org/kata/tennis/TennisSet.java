package org.kata.tennis;

public class TennisSet {

    private static final int GAMES_TO_WIN = 6;

    private int playerOneGames = 0;
    private int playerTwoGames = 0;

    private GameStrategy currentGame = new Game();

    // =========================
    // Punto ganado
    // =========================

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

    // =========================
    // Gestión de fin de Game
    // =========================

    private void checkGameFinished() {

        if (!currentGame.isFinished()) return;

        String winner = currentGame.getWinner();

        if ("Player 1".equals(winner)) {
            playerOneGames++;
        } else {
            playerTwoGames++;
        }

        if (shouldStartTieBreak()) {
            currentGame = new TieBreakGame();
        } else if (!isFinished()) {
            currentGame = new Game();
        }
    }

    private boolean shouldStartTieBreak() {
        return playerOneGames == GAMES_TO_WIN
                && playerTwoGames == GAMES_TO_WIN;
    }

    // =========================
    // Estado del Set
    // =========================

    public String getScore() {
        return playerOneGames + "-" + playerTwoGames;
    }

    public boolean isTieBreak() {
        return currentGame instanceof TieBreakGame;
    }

    public boolean isFinished() {

        // Si el game actual es tie-break y ha terminado,
        // el set termina automáticamente
        if (currentGame instanceof TieBreakGame && currentGame.isFinished()) {
            return true;
        }

        // Regla normal de set
        return (playerOneGames >= GAMES_TO_WIN || playerTwoGames >= GAMES_TO_WIN)
                && Math.abs(playerOneGames - playerTwoGames) >= 2;
    }

    public String getWinner() {
        if (!isFinished()) return null;

        return playerOneGames > playerTwoGames
                ? "Player 1"
                : "Player 2";
    }
}
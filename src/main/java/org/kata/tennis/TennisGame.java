package org.kata.tennis;

public class TennisGame {

    private int playerOnePoints = 0;

    public void playerOneScores() {
        playerOnePoints++;
    }

    public String getScore() {
        if (playerOnePoints == 0) {
            return "Love-Love";
        }
        if (playerOnePoints == 1) {
            return "Fifteen-Love";
        }
        return null;
    }
}

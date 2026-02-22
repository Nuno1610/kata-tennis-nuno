package org.kata.tennis;

public interface GameStrategy {

    void playerOneScores();
    void playerTwoScores();

    boolean isFinished();
    String getWinner();
}
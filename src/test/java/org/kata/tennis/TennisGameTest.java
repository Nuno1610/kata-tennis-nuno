package org.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisGameTest {

    @Test
    void shouldReturnLoveLove_OnStart() {
        TennisGame game = new TennisGame();
        assertEquals("Love-Love", game.getScore());
    }

    @Test
    void testPlayerOneScoresOnce_ShouldBeFifteenLove() {
        TennisGame game = new TennisGame();
        game.playerOneScores();
        assertEquals("Fifteen-Love", game.getScore());
    }

    @Test
    void testPlayerTwoScoresOnce_ShouldBeLoveFifteen() {
        TennisGame game = new TennisGame();
        game.playerTwoScores();
        assertEquals("Love-Fifteen", game.getScore());
    }

    @Test
    void testBothPlayersScoreOnce_ShouldBeFifteenAll() {
        TennisGame game = new TennisGame();
        game.playerOneScores();
        game.playerTwoScores();
        assertEquals("Fifteen-All", game.getScore());
    }

    @Test
    void testPlayerOneScoresTwice_ShouldBeThirtyLove() {
        TennisGame game = new TennisGame();
        game.playerOneScores();
        game.playerOneScores();
        assertEquals("Thirty-Love", game.getScore());
    }

    @Test
    void testPlayerTwoScoresTwice_ShouldBeLoveThirty() {
        TennisGame game = new TennisGame();
        game.playerTwoScores();
        game.playerTwoScores();
        assertEquals("Love-Thirty", game.getScore());
    }

    @Test
    void testScoreIsFortyAll_ShouldBeDeuce() {
        TennisGame game = new TennisGame();

        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();

        game.playerTwoScores();
        game.playerTwoScores();
        game.playerTwoScores();

        assertEquals("Deuce", game.getScore());
    }
}
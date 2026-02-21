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

    @Test
    void testPlayerOneAdvantageAfterDeuce_ShouldBeAdvantagePlayerOne() {
        TennisGame game = new TennisGame();

        // Llegamos a Deuce (3-3)
        for (int i = 0; i < 3; i++) {
            game.playerOneScores();
            game.playerTwoScores();
        }

        // Player 1 marca un punto más
        game.playerOneScores();

        assertEquals("Advantage Player 1", game.getScore());
    }

    @Test
    void testPlayerTwoAdvantageAfterDeuce_ShouldBeAdvantagePlayerTwo() {
        TennisGame game = new TennisGame();

        // Llegamos a Deuce (3-3)
        for (int i = 0; i < 3; i++) {
            game.playerOneScores();
            game.playerTwoScores();
        }

        // Player 2 marca un punto más
        game.playerTwoScores();

        assertEquals("Advantage Player 2", game.getScore());
    }

    @Test
    void testPlayerOneWinsAfterAdvantage_ShouldBeWinPlayerOne() {
        TennisGame game = new TennisGame();

        // Llegamos a Deuce (3-3)
        for (int i = 0; i < 3; i++) {
            game.playerOneScores();
            game.playerTwoScores();
        }

        // Player 1 consigue ventaja
        game.playerOneScores();

        // Player 1 vuelve a marcar
        game.playerOneScores();

        assertEquals("Player 1 wins", game.getScore());
    }

    @Test
    void testPlayerTwoWinsAfterAdvantage_ShouldBeWinPlayerTwo() {
        TennisGame game = new TennisGame();

        // Llegamos a Deuce (3-3)
        for (int i = 0; i < 3; i++) {
            game.playerOneScores();
            game.playerTwoScores();
        }

        // Player 2 consigue ventaja
        game.playerTwoScores();

        // Player 2 vuelve a marcar
        game.playerTwoScores();

        assertEquals("Player 2 wins", game.getScore());
    }

    @Test
    void testAdvantageLost_BackToDeuce() {
        TennisGame game = new TennisGame();

        // Llegamos a Deuce (3-3)
        for (int i = 0; i < 3; i++) {
            game.playerOneScores();
            game.playerTwoScores();
        }

        // Player 1 obtiene ventaja (4-3)
        game.playerOneScores();

        // Player 2 gana el siguiente punto (4-4)
        game.playerTwoScores();

        assertEquals("Deuce", game.getScore());
    }
}
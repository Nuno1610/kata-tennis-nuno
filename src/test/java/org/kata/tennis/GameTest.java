package org.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void shouldReturnLoveLove_OnStart() {
        Game game = new Game();
        assertEquals("Love-Love", game.getScore());
    }

    @Test
    void testPlayerOneScoresOnce_ShouldBeFifteenLove() {
        Game game = new Game();
        game.playerOneScores();
        assertEquals("Fifteen-Love", game.getScore());
    }

    @Test
    void testPlayerTwoScoresOnce_ShouldBeLoveFifteen() {
        Game game = new Game();
        game.playerTwoScores();
        assertEquals("Love-Fifteen", game.getScore());
    }

    @Test
    void testBothPlayersScoreOnce_ShouldBeFifteenAll() {
        Game game = new Game();
        game.playerOneScores();
        game.playerTwoScores();
        assertEquals("Fifteen-All", game.getScore());
    }

    @Test
    void testPlayerOneScoresTwice_ShouldBeThirtyLove() {
        Game game = new Game();
        game.playerOneScores();
        game.playerOneScores();
        assertEquals("Thirty-Love", game.getScore());
    }

    @Test
    void testPlayerTwoScoresTwice_ShouldBeLoveThirty() {
        Game game = new Game();
        game.playerTwoScores();
        game.playerTwoScores();
        assertEquals("Love-Thirty", game.getScore());
    }

    @Test
    void testScoreIsFortyAll_ShouldBeDeuce() {
        Game game = new Game();

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
        Game game = new Game();

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
        Game game = new Game();

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
        Game game = new Game();

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
        Game game = new Game();

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
        Game game = new Game();

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

    @Test
    void testPlayerOneWinsByTwoPoints_ShouldBeWinPlayerOne() {
        Game game = new Game();

        // Player 1 gana 4 puntos seguidos (4-0)
        for (int i = 0; i < 4; i++) {
            game.playerOneScores();
        }

        assertEquals("Player 1 wins", game.getScore());
    }

    @Test
    void testPlayerTwoWinsByTwoPoints_ShouldBeWinPlayerTwo() {
        Game game = new Game();

        // Player 2 gana 4 puntos seguidos (0-4)
        for (int i = 0; i < 4; i++) {
            game.playerTwoScores();
        }

        assertEquals("Player 2 wins", game.getScore());
    }
}
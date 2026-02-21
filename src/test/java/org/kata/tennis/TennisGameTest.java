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
}
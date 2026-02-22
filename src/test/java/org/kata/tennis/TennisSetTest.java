package org.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisSetTest {

    @Test
    void shouldStartAtZeroZero() {
        TennisSet set = new TennisSet();
        assertEquals("0-0", set.getScore());
        assertFalse(set.isFinished());
        assertNull(set.getWinner());
    }

    @Test
    void whenPlayerOneWinsOneGame_SetScoreShouldBeOneZero() {
        TennisSet set = new TennisSet();

        // Player 1 gana el game (4 puntos seguidos)
        for (int i = 0; i < 4; i++) {
            set.playerOneScores();
        }

        assertEquals("1-0", set.getScore());
    }

    @Test
    void whenPlayerTwoWinsOneGame_SetScoreShouldBeZeroOne() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 4; i++) {
            set.playerTwoScores();
        }

        assertEquals("0-1", set.getScore());
    }

    @Test
    void playerOneWinsTwoGames_ShouldBeTwoZero() {
        TennisSet set = new TennisSet();

        // Game 1
        for (int i = 0; i < 4; i++) set.playerOneScores();

        // Game 2
        for (int i = 0; i < 4; i++) set.playerOneScores();

        assertEquals("2-0", set.getScore());
    }

    @Test
    void playerOneWinsSetSixZero_ShouldFinishSet() {
        TennisSet set = new TennisSet();

        for (int g = 0; g < 6; g++) {
            for (int p = 0; p < 4; p++) {
                set.playerOneScores();
            }
        }

        assertEquals("6-0", set.getScore());
        assertTrue(set.isFinished());
        assertEquals("Player 1", set.getWinner());
    }

    @Test
    void sixFive_ShouldNotBeFinished() {
        TennisSet set = new TennisSet();

        // Player 1 gana 6 juegos
        for (int g = 0; g < 6; g++) {
            for (int p = 0; p < 4; p++) {
                set.playerOneScores();
            }
        }

        // Player 2 gana 5 juegos
        for (int g = 0; g < 5; g++) {
            for (int p = 0; p < 4; p++) {
                set.playerTwoScores();
            }
        }

        assertEquals("6-5", set.getScore());
        assertFalse(set.isFinished());
        assertNull(set.getWinner());
    }

    @Test
    void sevenFive_ShouldFinishSet() {
        TennisSet set = new TennisSet();

        // Player 1 gana 7 juegos
        for (int g = 0; g < 7; g++) {
            for (int p = 0; p < 4; p++) {
                set.playerOneScores();
            }
        }

        // Player 2 gana 5 juegos
        for (int g = 0; g < 5; g++) {
            for (int p = 0; p < 4; p++) {
                set.playerTwoScores();
            }
        }

        assertEquals("7-5", set.getScore());
        assertTrue(set.isFinished());
        assertEquals("Player 1", set.getWinner());
    }
}
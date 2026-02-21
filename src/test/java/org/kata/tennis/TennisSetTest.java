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
    void playerOneWinsOneGame_ShouldBeOneZero() {
        TennisSet set = new TennisSet();
        set.playerOneWinsGame();
        assertEquals("1-0", set.getScore());
    }

    @Test
    void playerTwoWinsOneGame_ShouldBeZeroOne() {
        TennisSet set = new TennisSet();
        set.playerTwoWinsGame();
        assertEquals("0-1", set.getScore());
    }

    @Test
    void playerOneWinsSixGames_ShouldWinSet_6_0() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 6; i++) {
            set.playerOneWinsGame();
        }

        assertEquals("6-0", set.getScore());
        assertTrue(set.isFinished());
        assertEquals("Player 1", set.getWinner());
    }

    @Test
    void playerOneWinsSixGamesWithTwoDifference_ShouldWinSet_6_4() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 6; i++) set.playerOneWinsGame();
        for (int i = 0; i < 4; i++) set.playerTwoWinsGame();

        assertEquals("6-4", set.getScore());
        assertTrue(set.isFinished());
        assertEquals("Player 1", set.getWinner());
    }

    @Test
    void sixFive_ShouldNotBeFinished() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 6; i++) set.playerOneWinsGame();
        for (int i = 0; i < 5; i++) set.playerTwoWinsGame();

        assertEquals("6-5", set.getScore());
        assertFalse(set.isFinished());
        assertNull(set.getWinner());
    }

    @Test
    void sevenFive_ShouldBeFinished() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 7; i++) set.playerOneWinsGame();
        for (int i = 0; i < 5; i++) set.playerTwoWinsGame();

        assertEquals("7-5", set.getScore());
        assertTrue(set.isFinished());
        assertEquals("Player 1", set.getWinner());
    }

    @Test
    void playerTwoWinsSet_ShouldReturnCorrectWinner() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 6; i++) {
            set.playerTwoWinsGame();
        }

        assertTrue(set.isFinished());
        assertEquals("Player 2", set.getWinner());
    }
}
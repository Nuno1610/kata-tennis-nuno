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
        winGameForPlayerOne(set);
        assertEquals("1-0", set.getScore());
    }

    @Test
    void whenPlayerTwoWinsOneGame_SetScoreShouldBeZeroOne() {
        TennisSet set = new TennisSet();
        winGameForPlayerTwo(set);
        assertEquals("0-1", set.getScore());
    }

    @Test
    void playerOneWinsTwoGames_ShouldBeTwoZero() {
        TennisSet set = new TennisSet();

        winGameForPlayerOne(set);
        winGameForPlayerOne(set);

        assertEquals("2-0", set.getScore());
    }

    @Test
    void playerOneWinsSetSixZero_ShouldFinishSet() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 6; i++) {
            winGameForPlayerOne(set);
        }

        assertEquals("6-0", set.getScore());
        assertTrue(set.isFinished());
        assertEquals("Player 1", set.getWinner());
    }

    @Test
    void sixFive_ShouldNotBeFinished() {
        TennisSet set = new TennisSet();

        // Llegamos a 5-5 alternando
        for (int i = 0; i < 5; i++) {
            winGameForPlayerOne(set);
            winGameForPlayerTwo(set);
        }

        // 6-5
        winGameForPlayerOne(set);

        assertEquals("6-5", set.getScore());
        assertFalse(set.isFinished());
        assertNull(set.getWinner());
    }

    @Test
    void sevenFive_ShouldFinishSet() {
        TennisSet set = new TennisSet();

        // Llegamos a 5-5 alternando
        for (int i = 0; i < 5; i++) {
            winGameForPlayerOne(set);
            winGameForPlayerTwo(set);
        }

        // 6-5
        winGameForPlayerOne(set);

        // 7-5
        winGameForPlayerOne(set);

        assertEquals("7-5", set.getScore());
        assertTrue(set.isFinished());
        assertEquals("Player 1", set.getWinner());
    }

    // ========================
    // Helpers
    // ========================

    private void winGameForPlayerOne(TennisSet set) {
        for (int i = 0; i < 4; i++) {
            set.playerOneScores();
        }
    }

    private void winGameForPlayerTwo(TennisSet set) {
        for (int i = 0; i < 4; i++) {
            set.playerTwoScores();
        }
    }
}
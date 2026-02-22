package org.kata.tennis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TennisSetTest {

    // =========================
    // Estado inicial
    // =========================

    @Test
    void shouldStartAtZeroZero() {
        TennisSet set = new TennisSet();

        assertEquals("0-0", set.getScore());
        assertFalse(set.isFinished());
        assertNull(set.getWinner());
        assertFalse(set.isTieBreak());
    }

    // =========================
    // Escenarios normales del set
    // =========================

    @ParameterizedTest
    @MethodSource("normalSetScenarios")
    void shouldEvaluateNormalSetCorrectly(
            int playerOneGames,
            int playerTwoGames,
            String expectedScore,
            boolean expectedFinished,
            String expectedWinner
    ) {
        TennisSet set = new TennisSet();

        simulateSet(set, playerOneGames, playerTwoGames);

        assertEquals(expectedScore, set.getScore());
        assertEquals(expectedFinished, set.isFinished());
        assertEquals(expectedWinner, set.getWinner());
    }

    static Stream<Arguments> normalSetScenarios() {
        return Stream.of(
                Arguments.of(6, 0, "6-0", true, "Player 1"),
                Arguments.of(6, 4, "6-4", true, "Player 1"),
                Arguments.of(6, 5, "6-5", false, null),
                Arguments.of(7, 5, "7-5", true, "Player 1"),
                Arguments.of(0, 6, "0-6", true, "Player 2"),
                Arguments.of(4, 6, "4-6", true, "Player 2")
        );
    }

    // =========================
    // Activación Tie-Break
    // =========================

    @Test
    void whenSixAll_ShouldEnterTieBreak() {
        TennisSet set = new TennisSet();

        simulateAlternatingGames(set, 6);

        assertEquals("6-6", set.getScore());
        assertTrue(set.isTieBreak());
        assertFalse(set.isFinished());
    }

    // =========================
    // Escenarios Tie-Break
    // =========================

    @ParameterizedTest
    @MethodSource("tieBreakScenarios")
    void shouldEvaluateTieBreakCorrectly(
            int p1Points,
            int p2Points,
            boolean expectedFinished,
            String expectedWinner
    ) {
        TennisSet set = new TennisSet();

        simulateAlternatingGames(set, 6); // Llegamos a 6-6

        simulateTieBreakPoints(set, p1Points, p2Points);

        assertEquals(expectedFinished, set.isFinished());
        assertEquals(expectedWinner, set.getWinner());
    }

    static Stream<Arguments> tieBreakScenarios() {
        return Stream.of(
                Arguments.of(6, 6, false, null),
                Arguments.of(7, 5, true, "Player 1"),
                Arguments.of(5, 7, true, "Player 2"),
                Arguments.of(8, 6, true, "Player 1"),
                Arguments.of(6, 8, true, "Player 2")
        );
    }

    // =========================
    // Helpers
    // =========================

    // =========================
// Helpers
// =========================

    private void simulateSet(TennisSet set, int p1Games, int p2Games) {

        int min = Math.min(p1Games, p2Games);

        // Alternamos hasta el mínimo
        for (int i = 0; i < min; i++) {
            winGameForPlayerOne(set);
            winGameForPlayerTwo(set);
        }

        // Juegos restantes de Player 1
        for (int i = 0; i < p1Games - min; i++) {
            winGameForPlayerOne(set);
        }

        // Juegos restantes de Player 2
        for (int i = 0; i < p2Games - min; i++) {
            winGameForPlayerTwo(set);
        }
    }

    private void simulateAlternatingGames(TennisSet set, int rounds) {
        for (int i = 0; i < rounds; i++) {
            winGameForPlayerOne(set);
            winGameForPlayerTwo(set);
        }
    }

    private void simulateTieBreakPoints(TennisSet set, int p1Points, int p2Points) {
        for (int i = 0; i < p1Points; i++) {
            set.playerOneScores();
        }
        for (int i = 0; i < p2Points; i++) {
            set.playerTwoScores();
        }
    }

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
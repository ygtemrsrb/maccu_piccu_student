package isc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GamePublicTest {

    private static class TestPlayer extends Player {
        TestPlayer(String name) {
            super(name);
        }

        @Override
        public void takeTurn(DiceGame game) {
            game.playTurn(this);
        }
    }

    @Test
    @DisplayName("playGame should reject non-positive turn counts")
    void playGameRejectsInvalidTurnCount() {
        Game game = new Game();

        assertThrows(IllegalArgumentException.class, () -> game.playGame("Ada", 0));
    }

    @Test
    @DisplayName("playTurn should produce a non-negative turn score")
    void playTurnProducesNonNegativeScore() {
        Game game = new Game();
        Player player = new TestPlayer("Ada");

        game.playTurn(player);

        assertTrue(player.getTurnScore() >= 0);
    }

    @Test
    @DisplayName("winner checks should execute safely for valid players")
    void winnerChecksExecuteWithoutError() {
        Game game = new Game();
        Player p1 = new TestPlayer("Ada");
        Player p2 = new TestPlayer("HAL");

        p1.setTurnScore(4);
        p2.setTurnScore(3);
        p1.setMatchScore();
        p2.setMatchScore();

        assertDoesNotThrow(() -> game.determineWinnerTurn(p1, p2));
        assertDoesNotThrow(() -> game.determineWinnerMatch(p1, p2));
    }
}

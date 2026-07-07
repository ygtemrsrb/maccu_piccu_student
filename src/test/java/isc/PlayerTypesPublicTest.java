package isc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTypesPublicTest {

    private static class FakeGame implements DiceGame {
        int playTurnCallCount = 0;
        Player lastPlayer = null;

        @Override
        public void playGame(String playerName, int numTurns) {
            // Not required for this test.
        }

        @Override
        public void playTurn(Player player) {
            playTurnCallCount++;
            lastPlayer = player;
            player.setTurnScore(7);
        }

        @Override
        public void determineWinnerTurn(Player player1, Player player2) {
            // Not required for this test.
        }

        @Override
        public void determineWinnerMatch(Player player1, Player player2) {
            // Not required for this test.
        }
    }

    @Test
    @DisplayName("HumanPlayer should complete a turn through the game interface")
    void humanPlayerUsesGameForTurn() {
        HumanPlayer human = new HumanPlayer("Ada");
        FakeGame game = new FakeGame();

        human.takeTurn(game);

        assertEquals(1, game.playTurnCallCount);
        assertEquals(human, game.lastPlayer);
        assertEquals(7, human.getTurnScore());
    }

    @Test
    @DisplayName("ComputerPlayer should complete a turn through the game interface")
    void computerPlayerUsesGameForTurn() {
        ComputerPlayer computer = new ComputerPlayer("HAL");
        FakeGame game = new FakeGame();

        computer.takeTurn(game);

        assertEquals(1, game.playTurnCallCount);
        assertEquals(computer, game.lastPlayer);
        assertEquals(7, computer.getTurnScore());
    }
}

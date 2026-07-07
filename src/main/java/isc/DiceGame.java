package isc;

public interface DiceGame {

    /**
     * Starts a complete match between a human player and the computer.
     * Plays the specified number of turns and determines the overall winner.
     * 
     * @param playerName the name of the human player
     * @param numTurns the number of turns to play in the match
     */
    void playGame(String playerName, int numTurns);

    /**
     * Executes a single turn for the given player.
     * Rolls dice, processes scores based on game rules (Base, Middle, Top),
     * and sets the player's turn score.
     * 
     * @param player the player whose turn it is
     */
    void playTurn(Player player);

    /**
     * Compares the turn scores of two players and announces the winner of that turn.
     * Also updates match scores.
     * 
     * @param player1 the first player
     * @param player2 the second player
     */
    void determineWinnerTurn(Player player1, Player player2);

    /**
     * Compares the overall match scores of two players and announces the match winner.
     * Called after all turns are completed.
     * 
     * @param player1 the first player
     * @param player2 the second player
     */
    void determineWinnerMatch(Player player1, Player player2);

}
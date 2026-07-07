package isc;

/**
 * Abstract base class representing a player in the Dice Game.
 * Tracks turn scores, match scores, and high scores across gameplay.
 * Subclasses implement specific player types (Human or Computer).
 */
public abstract class Player {
    /** Player's name */
    protected String name;
    
    /** Score accumulated in the current turn */
    protected int turnScore;
    
    /** Cumulative score across all turns in the match */
    protected int matchScore;
    
    /** Highest single-turn score achieved by this player */
    protected int highScore;
    
    /**
     * Initializes a player with a given name.
     * Sets all scores to 0 and high score to 0.
     * 
     * @param name the player's name
     */
    public Player(String name) {
        this.name = name;
        this.turnScore = 0;
        resetTurnScore();
        resetMatchScore();
        this.highScore = 0;
    }
    
    /**
     * Abstract method for subclasses to implement player-specific turn logic.
     * 
     * @param game the game instance to interact with
     */
    public abstract void takeTurn(DiceGame game);

    /**
     * Gets the player's name.
     * 
     * @return the player's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the score from the current turn.
     * 
     * @return the turn score
     */
    public int getTurnScore() {
        return turnScore;
    }
    
    /**
     * Sets the turn score and updates high score if the new score is higher.
     * 
     * @param score the score for this turn
     */
    public void setTurnScore(int score) {
        this.turnScore = score;
        if (score > highScore) {
            highScore = score;
        }
    }

    /**
     * Gets the cumulative match score.
     * 
     * @return the total match score
     */
    public int getMatchScore() {
        return matchScore;
    }
    
    /**
     * Resets the match score to 0 (used at the start of a new match).
     */
    public void resetMatchScore() {
        this.matchScore = 0;
    }

    /**
     * Resets the turn score to 0 (used at the start of a new turn).
     */
    public void resetTurnScore() {
        this.turnScore = 0;
    }

    /**
     * Adds the current turn score to the match score.
     * Called after each turn to accumulate scores.
     */
    public void setMatchScore() {
        this.matchScore += turnScore;
    }

    /**
     * Gets the player's highest single-turn score.
     * 
     * @return the high score
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * Returns a string representation of the player.
     * 
     * @return formatted player information
     */
    public String toString() {
        return "Player{name='" + name + "', score=" + turnScore + ", highScore=" + highScore + "}";
    }
}

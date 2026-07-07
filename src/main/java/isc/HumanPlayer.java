package isc;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void takeTurn(DiceGame game) {
        game.playTurn(this);
    }

    @Override
    public int getHighScore() {
        return highScore;
    }

    @Override
    public String toString() {
        return "HumanPlayer{name='" + name + "', score=" + turnScore + ", highScore=" + highScore + "}";
    }
}

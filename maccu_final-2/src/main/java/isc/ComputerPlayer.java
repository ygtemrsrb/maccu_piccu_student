package isc;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
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
        return "ComputerPlayer{name='" + name + "', score=" + turnScore + ", highScore=" + highScore + "}";
    }
}

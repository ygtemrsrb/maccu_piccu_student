package isc;

public class Main {
    public static void main(String[] args) {
        System.out.println("Maccu Piccu Game");
        //Dice.showDice(Dice.getDice());
        DiceGame game = new Game();
        game.playGame("Darren", 3);
    }
}
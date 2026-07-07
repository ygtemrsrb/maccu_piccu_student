package isc;

public class Dice {
    public static final int MAX_DICE_VALUE = 6;
    public static final int MAX_DICE = 5;
    private static int roll() {
        // Simulate rolling a dice and return a value between 1 and 6
        return (int) (Math.random() * MAX_DICE_VALUE) + 1;
    }

    public static int[] rollDice(int numberOfDice) {
        int[] results = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            results[i] = roll();
        }
        return results;
    }

    public static int[][]  getDice() {
        int[][] results = new int[MAX_DICE][];
        for (int i = 0; i < MAX_DICE; i++) {
            results[i] = rollDice(MAX_DICE);
        }
        return results;
    }

    public static void showDice(int[][] dice) {
        for (int i = 0; i < dice.length; i++) {
            System.out.print("Dice " + (i + 1) + ": ");
            for (int j = 0; j < dice[i].length; j++) {
                System.out.print(dice[i][j] + " ");
            }
            System.out.println();
        }
    }
}

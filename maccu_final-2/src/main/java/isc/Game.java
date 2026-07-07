package isc;

@SuppressWarnings("unused")
public class Game implements DiceGame {
    private boolean base;
    private boolean middle;
    private boolean top;
    private final Menu menu;

    public Game() {
        this.menu = new Menu();
        resetFlags();
    }

    public Game(Menu menu) {
        this.menu = menu;
        resetFlags();
    }

    public void resetFlags() {
        this.base = false;
        this.middle = false;
        this.top = false;
    }

    @Override
    public void playGame(String playerName, int numTurns) {
        if (numTurns <= 0) {
            throw new IllegalArgumentException("Number of turns must be positive.");
        }
        if (playerName == null || playerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be empty.");
        }

        Player human = new HumanPlayer(playerName.trim());
        Player computer = new ComputerPlayer("Computer");

        human.resetMatchScore();
        computer.resetMatchScore();

        for (int turn = 1; turn <= numTurns; turn++) {
            System.out.println("\n--- Turn " + turn + " of " + numTurns + " ---");

            System.out.println("\n" + human.getName() + "'s turn");
            human.takeTurn(this);

            System.out.println("\n" + computer.getName() + "'s turn");
            computer.takeTurn(this);

            human.setMatchScore();
            computer.setMatchScore();

            System.out.println("\nTurn " + turn + " result:");
            determineWinnerTurn(human, computer);
            System.out.println(human.getName() + " match score: " + human.getMatchScore());
            System.out.println(computer.getName() + " match score: " + computer.getMatchScore());

            if (turn < numTurns) {
                menu.continueGame();
            }
        }

        System.out.println("\n--- Final Match Result ---");
        determineWinnerMatch(human, computer);
    }

    @Override
    public void playTurn(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null.");
        }

        resetFlags();
        player.resetTurnScore();
        int turnScore = 0;
        int[][] rolls = Dice.getDice();

        for (int rollIndex = 0; rollIndex < rolls.length; rollIndex++) {
            int[] dice = rolls[rollIndex];
            System.out.print("Roll " + (rollIndex + 1) + ": ");

            for (int die : dice) {
                System.out.print(die + " ");
            }
            System.out.println();

            for (int die : dice) {
                if (!base) {
                    if (die == 6) {
                        base = true;
                        System.out.println("Base found (6)");
                    }
                } else if (!middle) {
                    if (die == 3) {
                        middle = true;
                        System.out.println("Middle found (3)");
                    }
                } else if (!top) {
                    if (die == 1) {
                        top = true;
                        System.out.println("Top found (1)");
                    }
                } else {
                    turnScore += die;
                }
            }
        }

        player.setTurnScore(turnScore);
        System.out.println(player.getName() + " scored " + turnScore + " this turn.");
    }

    private void determineWinner(Player player1, int score1, Player player2, int score2) {
        if (score1 > score2) {
            System.out.println(player1.getName() + " wins with a score of " + score1 + " against " + player2.getName() + "'s score of " + score2);
        } else if (score2 > score1) {
            System.out.println(player2.getName() + " wins with a score of " + score2 + " against " + player1.getName() + "'s score of " + score1);
        } else {
            System.out.println("It's a tie!");
        }
    }

    @Override
    public void determineWinnerTurn(Player player1, Player player2) {
        determineWinner(player1, player1.getTurnScore(), player2, player2.getTurnScore());
    }

    @Override
    public void determineWinnerMatch(Player player1, Player player2) {
        determineWinner(player1, player1.getMatchScore(), player2, player2.getMatchScore());
    }
}

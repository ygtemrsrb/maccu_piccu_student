package isc;

import java.io.InputStream;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        this(System.in);
    }

    public Menu(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displayMenu() {
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
    }

    public String getPlayerName() {
        String name;
        do {
            name = getUserInput("Enter your name: ").trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            }
        } while (name.isEmpty());
        return name;
    }

    public int getUserChoice() {
        while (true) {
            String input = getUserInput("Choose an option (1-2): ").trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice == 1 || choice == 2) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
                // handled below
            }
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    public void continueGame() {
        System.out.println("Press Enter to continue...");
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public boolean askToPlayAgain() {
        while (true) {
            String input = getUserInput("Play again? (y/n): ").trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            }
            if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.println("Invalid response. Please enter y or n.");
        }
    }
}

import java.util.Scanner;

import decks.Deck;
import decks.Red;
import outputUtils.Colored;
import outputUtils.ColorCode;

public class GameManager {

    // RIBADISCO CHE OGNI COSA IN QUESTA CLASSE **DEVE** ESSERE STATICA

    private static long seed;
    private static boolean isGameOngoing;
    private static Deck currentDeck;

    public static void displayMenu() {
        Colored.println("=== Game Menu ===", ColorCode.CYAN_BOLD);
        Colored.println("1. Start New Game", ColorCode.GREEN);
        Colored.println("2. Set Seed", ColorCode.YELLOW);
        Colored.println("3. Select Deck", ColorCode.PURPLE);
        Colored.println("4. Quit", ColorCode.RED);
        Colored.print("Enter your choice: ", ColorCode.WHITE_BOLD);
    }

    public static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> startNewGame();
            case 2 -> promptForSeed();
            case 3 -> selectDeck();
            case 4 -> {
                Colored.println("Thanks for playing. Goodbye!", ColorCode.PURPLE);
                System.exit(0);
            }
            default -> {
                Colored.println("Invalid choice. Please try again.", ColorCode.RED_BOLD);
            }
        }
    }

    public static void setSeed(long newSeed) {
        if(isGameOngoing) {
            throw new RuntimeException("Cannot change seed while game is running.");
        }
        seed = newSeed;
    }

    public static void selectDeck() {
        Colored.println("Set a valid Deck type: ", ColorCode.PURPLE);
        currentDeck = new Red(seed);
    }

    private static void startNewGame() {
        Scanner scanner = new Scanner(System.in);
        if (seed == 0) {
            Colored.println("Please set a seed before starting the game.", ColorCode.YELLOW_BOLD);
            return;
        }
        isGameOngoing = true;
        Colored.println("Starting new game with seed: " + seed, ColorCode.GREEN_BOLD);
        currentDeck.shuffle();

        while(true) {
            currentDeck.draw(currentDeck.getHandSize());
            System.out.println(currentDeck.getHandCards());
            scanner.nextLine();
        }
    }

    private static void promptForSeed() {
        Scanner scanner = new Scanner(System.in);
        Colored.print("Enter a seed value: ", ColorCode.CYAN);
        long newSeed = scanner.nextLine().hashCode();
        setSeed(newSeed);
        Colored.println("Seed set to: " + newSeed, ColorCode.GREEN);
    }
}

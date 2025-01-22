import java.util.Scanner;
import outputUtils.Colored;
import outputUtils.ColorCode;

public class GameManager {

    private static long seed;
    private static boolean isGameOngoing;

    public void displayMenu() {
        Colored.println("=== Game Menu ===", ColorCode.CYAN_BOLD);
        Colored.println("1. Start New Game", ColorCode.GREEN);
        Colored.println("2. Set Seed", ColorCode.YELLOW);
        Colored.println("3. Quit", ColorCode.RED);
        Colored.print("Enter your choice: ", ColorCode.WHITE_BOLD);
    }

    public void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                startNewGame();
                break;
            case 2:
                promptForSeed();
                break;
            case 3:
                Colored.println("Thanks for playing. Goodbye!", ColorCode.PURPLE);
                System.exit(0);
                break;
            default:
                Colored.println("Invalid choice. Please try again.", ColorCode.RED_BOLD);
        }
    }

    public void setSeed(long newSeed) {
        if(isGameOngoing) {
            throw new RuntimeException("Cannot change seed while game is running.");
        }
        seed = newSeed;
    }

    private void startNewGame() {
        if (seed == 0) {
            Colored.println("Please set a seed before starting the game.", ColorCode.YELLOW_BOLD);
            return;
        }
        isGameOngoing = true;
        Colored.println("Starting new game with seed: " + seed, ColorCode.GREEN_BOLD);
    }

    private void promptForSeed() {
        Scanner scanner = new Scanner(System.in);
        Colored.print("Enter a seed value: ", ColorCode.CYAN);
        long newSeed = scanner.nextLong();
        setSeed(newSeed);
        Colored.println("Seed set to: " + newSeed, ColorCode.GREEN);
    }
}

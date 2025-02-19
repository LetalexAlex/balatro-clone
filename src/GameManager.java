import java.util.Arrays;
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
        /*
        if (seed == 0) {
            Colored.println("Please set a seed before starting the game.", ColorCode.YELLOW_BOLD);
            return;
        }
        */
        isGameOngoing = true;
        Colored.println("Starting new game with seed: " + seed, ColorCode.GREEN_BOLD);
        if(currentDeck == null) {
            currentDeck = new Red(seed); // TODO - selezione deck
        }
        currentDeck.generateDeck();
        currentDeck.shuffle();
        while(true) {
            currentDeck.resetSelectedCards();
            System.out.println("Enter to draw.");
            scanner.nextLine();
            debugDeckstate();
            try {
                System.out.println("drawing " + (currentDeck.getHandCards().size() - currentDeck.getHandSize()) + " cards.");
                currentDeck.draw(currentDeck.getHandSize() - currentDeck.getHandCards().size());
                debugDeckstate();
                /*
                System.out.println("sorting hand cards. (suit)");
                currentDeck.sortHand(Deck.suitSorter());
                debugDeckstate();
                */
                System.out.println("sorting hand cards. (rank)");
                currentDeck.sortHand(Deck.rankSorter());
                debugDeckstate();
            } catch (IllegalArgumentException e) {
                Colored.println("Error: Deck has run out of cards.", ColorCode.RED_BOLD);
            }
            System.out.println("Select cards to play by index separated by comma (\"0,1,2,3,4\"): ");
            String selected = scanner.nextLine();
            String[] SelectedArr = selected.split(",");
            int[] indexesSelectedArr = new int[SelectedArr.length];
            for(int i = 0; i < SelectedArr.length; i++) {
                try {
                    indexesSelectedArr[i] = Integer.parseInt(SelectedArr[i]);
                }
                catch(NumberFormatException e) {
                    throw new RuntimeException("cannot select \"" + SelectedArr[i] + "\" as a number");
                }
            }
            Arrays.sort(indexesSelectedArr);
            currentDeck.selectCards(indexesSelectedArr);
            debugDeckstate();
            if(ScoreManager.containsPair(currentDeck.getSelectedCards()))
                Colored.println("PAIR", ColorCode.RED_BOLD);
            if(ScoreManager.containsThreeOfAKind(currentDeck.getSelectedCards()))
                Colored.println("THREE", ColorCode.RED_BOLD);
            if(ScoreManager.containsFourOfAKind(currentDeck.getSelectedCards()))
                Colored.println("FOUR", ColorCode.RED_BOLD);
            if(ScoreManager.containsStraight(currentDeck.getSelectedCards()))
                Colored.println("STRAIGHT", ColorCode.RED_BOLD);

        }
    }

    private static void promptForSeed() {
        Scanner scanner = new Scanner(System.in);
        Colored.print("Enter a seed value: ", ColorCode.CYAN);
        long newSeed = scanner.nextLine().hashCode();
        setSeed(newSeed);
        Colored.println("Seed set to: " + newSeed, ColorCode.GREEN);
    }

    public static void debugDeckstate() {
        System.out.println("Current Hand: " + currentDeck.getHandCards());
        System.out.println("Selected Cards: " + currentDeck.getSelectedCards());
        //System.out.println("Remaining Deck: " + currentDeck.getDeckCards());
    }

    public static Deck getCurrentDeck() {
        return currentDeck;
    }
}

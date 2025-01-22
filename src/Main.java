import decks.Red;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            gameManager.displayMenu();
            int choice = scanner.nextInt();
            gameManager.handleMenuChoice(choice);
        }
    }
}
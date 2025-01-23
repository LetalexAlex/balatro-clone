import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            GameManager.displayMenu();
            int choice = scanner.nextInt();
            GameManager.handleMenuChoice(choice);
        }
    }
}
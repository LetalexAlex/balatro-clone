import decks.Red;

public class Main {
    public static void main(String[] args) {
        long seed = "TUTORIAL".hashCode();
        Red deck = new Red();
        deck.shuffle(seed);
        System.out.println(deck.getDeckCards());
        deck.draw(8);
        deck.sortHand();
        System.out.println(deck.getHandCards());

    }
}
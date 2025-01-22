package decks;

import cards.Card;
import enums.Ranks;
import enums.Suits;
import jokers.Joker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * The {@code Deck} class provides an abstract representation of a deck of cards.
 * It includes functionality for generating, shuffling, and drawing cards, as well
 * as sorting a player's hand. A deck may also include jokers and support multiple hands.
 */
public abstract class Deck {
    /**
     *  Maximim number of hands that the deck can allow. after round it will be reset to this number
     */
    protected int maxHands;

    /**
     * The number of available hands.
     */
    protected int hands;

    /**
     * Maximim number of discards that the deck can allow. after round it will be reset to this number
     */
    protected int maxDiscards;

    /**
     * The number of available discards.
     */
    protected int discards;

    /**
     * The maximum size of each hand.
     */
    protected int handSize;

    /**
     * The list of cards still in the deck.
     */
    protected final ArrayList<Card> deckCards;

    /**
     * The list of cards currently in hand.
     */
    protected final ArrayList<Card> handCards;

    /**
     * The list of cards that will be played/discarded.
     */
    protected final ArrayList<Card> selectedCards;

    /**
     * The list of cards that have been discarded.
     */
    protected final ArrayList<Card> discardedCards;

    /**
     * The list of jokers.
     */
    protected final ArrayList<Joker> jokers;

    /**
     * A {@code Random} instance used for shuffling the deck.
     */
    private final Random random;

    /**
     * Constructs a new {@code Deck} with the specified number of hands, discards, hand size, and a random seed.
     *
     * @param hands    The initial number of hands the deck will allow.
     * @param discards The initial number of discards the deck will allow.
     * @param handSize The maximum size of each player's hand.
     * @param seed     The seed used for random shuffling of the deck.
     */
    public Deck(int hands, int discards, int handSize, long seed) {
        this.hands = hands;
        this.maxHands = hands;
        this.discards = discards;
        this.maxDiscards = discards;
        this.handSize = handSize;
        this.deckCards = new ArrayList<>();
        this.handCards = new ArrayList<>();
        this.discardedCards = new ArrayList<>();
        this.selectedCards = new ArrayList<>();
        this.jokers = new ArrayList<>();
        this.random = new Random(seed);
    }

    /**
     * Generates a standard deck of 52 playing cards. This method iterates through
     * all predefined ranks and suits to create each card and adds them to the deck.
     * <p>
     * Override this method to create a custom deck structure if required.
     */
    public void generateDeck() {
        for (Suits suit : Suits.values())
            for (Ranks rank : Ranks.values())
                deckCards.add(new Card(rank, suit));
        //System.out.println(deckCards);
    }

    public void selectCards(int index) {
        if (index < 0 || index >= handCards.size())
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for hand cards.");
        if (selectedCards.size() < 5)
            selectedCards.add(handCards.get(index));
        else
            throw new IllegalStateException("Cannot select more cards than the allowed hand size.");
    }

    /**
     * Draws a specified number of cards from the deck and adds them to the hand.
     *
     * This method removes the specified number of cards from the top of the deck
     * and places them into the player's hand. If the requested number of cards
     * exceeds the size of the deck, an {@link IllegalArgumentException} is thrown.
     *
     * @param n The number of cards to draw from the deck.
     * @throws IllegalArgumentException if the number of cards to draw is greater
     *                                  than the number of cards in the deck.
     */
    public void draw(int n) {
        if (n > deckCards.size())
            throw new IllegalArgumentException("Not enough cards in the deck to draw " + n + " cards.");
        for (int i = 0; i < n; i++) {
            this.handCards.add(this.deckCards.remove(0));
        }
    }

    /**
     * Shuffles the deck by randomizing the order of the cards.
     *
     * This method performs the following steps:
     * 1. Moves all selected cards back to the player's hand.
     * 2. Moves all cards from the player's hand to the discard pile.
     * 3. Moves all discarded cards back into the main deck.
     * 4. Randomizes the order of the cards in the deck using the Fisher-Yates shuffle algorithm.
     *
     * The shuffling uses a provided random seed to ensure deterministic behavior when required.
     * This method is intended to reset and randomize the deck for gameplay.
     */
    public void shuffle() {
        handCards.addAll(selectedCards);
        discardedCards.addAll(handCards);
        deckCards.addAll(discardedCards);
        int deckSize = deckCards.size();
        for (int i = deckSize - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            Card tempCard = deckCards.get(i);
            deckCards.set(i, deckCards.get(randomIndex));
            deckCards.set(randomIndex, tempCard);
        }
    }

    /**
     * Sorts the player's hand using the provided comparator.
     *
     * @param comparator The comparator specifying the sorting logic (e.g., by suit, rank).
     */
    public void sortHand(Comparator<Card> comparator) {
        handCards.sort(comparator);
    }

    /**
     * Returns a comparator to sort cards by suit and rank in descending order.
     */
    public static Comparator<Card> suitSorter() {
        return Comparator
                .comparing(Card::getSuit, Comparator.reverseOrder())
                .thenComparing(Card::getRank, Comparator.reverseOrder());
    }

    /**
     * Returns a comparator to sort cards by rank only (ignoring suits) in descending order.
     * Ensures stable sorting for persistent order.
     */
    public static Comparator<Card> rankSorter() {
        return Comparator.comparing(Card::getRank, Comparator.reverseOrder());
    }

    /**
     * Returns the list of cards currently in the deck.
     *
     * @return An {@code ArrayList} of {@code Card} objects in the deck.
     */
    public ArrayList<Card> getDeckCards() {
        return deckCards;
    }

    /**
     * Returns the list of cards in the current hand.
     *
     * @return An {@code ArrayList} of {@code Card} objects in hand(s).
     */
    public ArrayList<Card> getHandCards() {
        return handCards;
    }

    public ArrayList<Card> getSelectedCards() {
        return selectedCards;
    }

    /**
     * Returns the maximum size of each hand.
     *
     * @return The maximum size of each hand as an integer.
     */
    public int getHandSize() {
        return handSize;
    }
}

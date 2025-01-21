package decks;

import cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public abstract class Deck {
    protected int hands;
    protected int discards;
    protected int handsSize;
    protected final ArrayList<Card> deckCards;
    protected final ArrayList<Card> handCards;
    protected final ArrayList<Card> discardedCards;

    public Deck(int hands, int discards, int handsSize){
        this.hands=hands;
        this.discards=discards;
        this.handsSize=handsSize;
        this.deckCards=new ArrayList<>();
        this.handCards=new ArrayList<>();
        this.discardedCards=new ArrayList<>();
        generateDeck();
    }

    protected abstract void generateDeck();

    public void draw(int numberOfCardsToBeDrawed) {
        for (int i = 0; i < numberOfCardsToBeDrawed; i++)
            this.handCards.add(this.deckCards.removeFirst());
    }

    public void shuffle(long seed) {
        deckCards.addAll(discardedCards);
        Random random = new Random(seed);
        int deckSize = deckCards.size();
        for (int i = deckSize - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            Card tempCard = deckCards.get(i);
            deckCards.set(i, deckCards.get(randomIndex));
            deckCards.set(randomIndex, tempCard);
        }
    }

    public void sortHand() {
        Collections.sort(this.handCards, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                int semeComparison = c2.getSuit().compareTo(c1.getSuit());
                if (semeComparison != 0) {
                    return semeComparison;
                }
                return c2.getRank().compareTo(c1.getRank());
            }
        });

    }

    public ArrayList<Card> getDeckCards() {
        return deckCards;
    }

    public ArrayList<Card> getHandCards() {
        return handCards;
    }

}

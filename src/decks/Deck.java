package decks;

import cards.Card;

import java.util.ArrayList;
import java.util.Random;

public abstract class Deck {
    protected int hands;
    protected int discards;
    protected int handsSize;
    protected ArrayList<Card> deckCards;
    protected ArrayList<Card> handCards;
    protected ArrayList<Card> discardedCards;

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

}

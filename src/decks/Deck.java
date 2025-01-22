package decks;

import cards.Card;
import enums.Ranks;
import enums.Suits;

import java.util.ArrayList;
import java.util.Random;

public abstract class Deck {
    protected int hands;
    protected int discards;
    protected int handsSize;
    protected final ArrayList<Card> deckCards;
    protected final ArrayList<Card> handCards;
    protected final ArrayList<Card> discardedCards;
    private final Random random;

    public Deck(int hands, int discards, int handsSize, long seed){
        this.hands=hands;
        this.discards=discards;
        this.handsSize=handsSize;
        this.deckCards=new ArrayList<>();
        this.handCards=new ArrayList<>();
        this.discardedCards=new ArrayList<>();
        generateDeck();
        this.random = new Random(seed);
    }

    protected void generateDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deckCards.add(new Card(Ranks.values()[j], Suits.values()[i]));
            }
        }
        System.out.println(deckCards);
    }

    public void draw(int numberOfCardsToBeDrawed) {
        for (int i = 0; i < numberOfCardsToBeDrawed; i++)
            this.handCards.add(this.deckCards.removeFirst());
    }

    public void shuffle() {
        deckCards.addAll(discardedCards);
        int deckSize = deckCards.size();
        for (int i = deckSize - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            Card tempCard = deckCards.get(i);
            deckCards.set(i, deckCards.get(randomIndex));
            deckCards.set(randomIndex, tempCard);
        }
    }

    public void sortHand() {
        handCards.sort((c1, c2) -> {
            int semeComparison = c2.getSuit().compareTo(c1.getSuit());
            if (semeComparison != 0) {
                return semeComparison;
            }
            return c2.getRank().compareTo(c1.getRank());
        });

    }

    public ArrayList<Card> getDeckCards() {
        return deckCards;
    }

    public ArrayList<Card> getHandCards() {
        return handCards;
    }

}

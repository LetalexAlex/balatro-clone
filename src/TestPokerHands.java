import cards.Card;
import enums.PokerHands;
import enums.Ranks;
import enums.Suits;
import outputUtils.ColorCode;
import outputUtils.Colored;

import java.util.ArrayList;
import java.util.Arrays;

public class TestPokerHands {
    public static void main(String[] args) {

        GameManager.selectDeck();

        // Test hands
        ArrayList<Card> highCard = createHand(new Card(Ranks.ACE, Suits.CLUBS),
                new Card(Ranks.THREE, Suits.DIAMONDS),
                new Card(Ranks.SEVEN, Suits.HEARTS),
                new Card(Ranks.NINE, Suits.SPADES),
                new Card(Ranks.JACK, Suits.CLUBS));

        ArrayList<Card> pair = createHand(new Card(Ranks.KING, Suits.HEARTS),
                new Card(Ranks.KING, Suits.CLUBS),
                new Card(Ranks.TWO, Suits.DIAMONDS),
                new Card(Ranks.FOUR, Suits.SPADES),
                new Card(Ranks.SIX, Suits.HEARTS));

        ArrayList<Card> twoPair = createHand(new Card(Ranks.QUEEN, Suits.HEARTS),
                new Card(Ranks.QUEEN, Suits.CLUBS),
                new Card(Ranks.EIGHT, Suits.DIAMONDS),
                new Card(Ranks.EIGHT, Suits.SPADES),
                new Card(Ranks.FIVE, Suits.CLUBS));

        ArrayList<Card> threeOfAKind = createHand(new Card(Ranks.JACK, Suits.HEARTS),
                new Card(Ranks.JACK, Suits.CLUBS),
                new Card(Ranks.JACK, Suits.DIAMONDS),
                new Card(Ranks.NINE, Suits.SPADES),
                new Card(Ranks.FOUR, Suits.HEARTS));

        ArrayList<Card> straight = createHand(new Card(Ranks.TEN, Suits.HEARTS),
                new Card(Ranks.NINE, Suits.CLUBS),
                new Card(Ranks.EIGHT, Suits.DIAMONDS),
                new Card(Ranks.SEVEN, Suits.SPADES),
                new Card(Ranks.SIX, Suits.CLUBS));

        ArrayList<Card> flush = createHand(new Card(Ranks.ACE, Suits.SPADES),
                new Card(Ranks.TEN, Suits.SPADES),
                new Card(Ranks.SIX, Suits.SPADES),
                new Card(Ranks.THREE, Suits.SPADES),
                new Card(Ranks.TWO, Suits.SPADES));

        ArrayList<Card> fullHouse = createHand(new Card(Ranks.KING, Suits.HEARTS),
                new Card(Ranks.KING, Suits.CLUBS),
                new Card(Ranks.KING, Suits.DIAMONDS),
                new Card(Ranks.FOUR, Suits.SPADES),
                new Card(Ranks.FOUR, Suits.HEARTS));

        ArrayList<Card> fourOfAKind = createHand(new Card(Ranks.ACE, Suits.HEARTS),
                new Card(Ranks.ACE, Suits.CLUBS),
                new Card(Ranks.ACE, Suits.DIAMONDS),
                new Card(Ranks.ACE, Suits.SPADES),
                new Card(Ranks.KING, Suits.CLUBS));

        ArrayList<Card> straightFlush = createHand(new Card(Ranks.NINE, Suits.CLUBS),
                new Card(Ranks.EIGHT, Suits.CLUBS),
                new Card(Ranks.SEVEN, Suits.CLUBS),
                new Card(Ranks.SIX, Suits.CLUBS),
                new Card(Ranks.FIVE, Suits.CLUBS));

        ArrayList<Card> royalFlush = createHand(new Card(Ranks.ACE, Suits.HEARTS),
                new Card(Ranks.KING, Suits.HEARTS),
                new Card(Ranks.QUEEN, Suits.HEARTS),
                new Card(Ranks.JACK, Suits.HEARTS),
                new Card(Ranks.TEN, Suits.HEARTS));
        // Test for Five of a Kind (if allowed in your game rules)
        ArrayList<Card> fiveOfAKind = createHand(new Card(Ranks.ACE, Suits.CLUBS),
                new Card(Ranks.ACE, Suits.DIAMONDS),
                new Card(Ranks.ACE, Suits.HEARTS),
                new Card(Ranks.ACE, Suits.SPADES),
                new Card(Ranks.ACE, Suits.CLUBS));

        // Test for Flush Five (flush with five of a kind)
        ArrayList<Card> flushFive = createHand(new Card(Ranks.ACE, Suits.HEARTS),
                new Card(Ranks.ACE, Suits.HEARTS),
                new Card(Ranks.ACE, Suits.HEARTS),
                new Card(Ranks.ACE, Suits.HEARTS),
                new Card(Ranks.ACE, Suits.HEARTS));

        // Test for Flush House (flush and full house)
        ArrayList<Card> flushHouse = createHand(new Card(Ranks.KING, Suits.CLUBS),
                new Card(Ranks.KING, Suits.CLUBS),
                new Card(Ranks.KING, Suits.CLUBS),
                new Card(Ranks.QUEEN, Suits.CLUBS),
                new Card(Ranks.QUEEN, Suits.CLUBS));

        // Run tests
        testAll(highCard, PokerHands.HIGH_CARD);
        testAll(pair, PokerHands.PAIR);
        testAll(twoPair, PokerHands.TWO_PAIRS);
        testAll(threeOfAKind, PokerHands.THREE_OF_A_KIND);
        testAll(straight, PokerHands.STRAIGHT);
        testAll(flush, PokerHands.FLUSH);
        testAll(fullHouse, PokerHands.FULL_HOUSE);
        testAll(fourOfAKind, PokerHands.FOUR_OF_A_KIND);
        testAll(straightFlush, PokerHands.STRAIGHT_FLUSH);
        testAll(royalFlush, PokerHands.ROYAL_FLUSH);
        testAll(fiveOfAKind, PokerHands.FIVE_OF_A_KIND);
        testAll(flushFive, PokerHands.FLUSH_FIVE);
        testAll(flushHouse, PokerHands.FLUSH_HOUSE);
    }

    /**
     * Tests all poker hands in ScoreManager.
     * @param cards List of cards to test.
     */
    public static void testAll(ArrayList<Card> cards, PokerHands expected) {
        Colored.println("Testing hand: " + cards, ColorCode.LIME);
        if (ScoreManager.containsPair(cards)) {
            Colored.println("PAIR detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsTwoPair(cards)) {
            Colored.println("TWO PAIR detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsThreeOfAKind(cards)) {
            Colored.println("THREE OF A KIND detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsStraight(cards)) {
            Colored.println("STRAIGHT detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsFlush(cards)) {
            Colored.println("FLUSH detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsFullHouse(cards)) {
            Colored.println("FULL HOUSE detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsFourOfAKind(cards)) {
            Colored.println("FOUR OF A KIND detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsStraightFlush(cards)) {
            Colored.println("STRAIGHT FLUSH detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsRoyalFlush(cards)) {
            Colored.println("ROYAL FLUSH detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsFiveOfAKind(cards)) {
            Colored.println("FIVE OF A KIND detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsFlushFive(cards)) {
            Colored.println("FLUSH FIVE detected", ColorCode.RED_BOLD);
        }
        if (ScoreManager.containsFlushHouse(cards)) {
            Colored.println("FLUSH HOUSE detected", ColorCode.RED_BOLD);
        }

        Colored.println("Expected: " + expected, ColorCode.PURPLE);
        Colored.println("Got: " + ScoreManager.getBestHand(cards), ColorCode.GREEN);

        System.out.println();
    }

    /**
     * Utility method to create a hand of cards.
     * @param cards Cards to include in the hand.
     * @return ArrayList containing the given cards.
     */
    public static ArrayList<Card> createHand(Card... cards) {
        ArrayList<Card> hand = new ArrayList<>(Arrays.asList(cards));
        return hand;
    }
}

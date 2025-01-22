import cards.Card;
import decks.Deck;
import enums.PokerHands;

import java.util.ArrayList;

public class ScoreManager {
    public static boolean containsFourOfAKind(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsThreeOfAKind(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsPair(ArrayList<Card> cards) {
        if(cards.size() < 2) return false;
        cards.sort(Deck.rankSorter());
        for(int i = 0; i < cards.size() - 1; i++) {
            if(cards.get(i).getRank() == cards.get(i+1).getRank())
                return true;
        }
        return false;
    }
    public static boolean containsStraight(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsFlush(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsFullHouse(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsRoyalFlush(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsStraightFlush(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsFlushFive(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsFiveOfAKind(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsFlushHouse(ArrayList<Card> cards) {
        return false;
    }
    public static boolean containsTwoPair(ArrayList<Card> cards) {
        return false;
    }
    public static PokerHands getBestHand(ArrayList<Card> cards) {
        return null;
    }
}

import cards.Card;
import decks.Deck;
import enums.PokerHands;
import enums.Ranks;

import java.util.ArrayList;

public class ScoreManager {
    public static boolean containsFourOfAKind(ArrayList<Card> cards) {
        if(cards.size() < 4) return false;
        cards.sort(Deck.rankSorter());
        initial: for (int i = 0; i < cards.size() - 3; i++) {
            Ranks rank = cards.get(i).getRank();
            for (int j = 1; j < 4; j++) {
                if(cards.get(i + j).getRank() != rank) continue initial;
            }
            return true;
        }
        return false;
    }
    public static boolean containsThreeOfAKind(ArrayList<Card> cards) {
        if(cards.size() < 3) return false;
        cards.sort(Deck.rankSorter());
        for (int i = 0; i < cards.size() - 2; i++) {
            if(cards.get(i).getRank() == cards.get(i + 1).getRank() && cards.get(i).getRank() == cards.get(i + 2).getRank()) {
                return true;
            }
        }
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
        if(cards.size() < GameManager.getCurrentDeck())
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

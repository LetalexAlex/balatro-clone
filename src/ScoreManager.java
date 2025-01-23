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
        if (cards.size() < GameManager.getCurrentDeck().getMinStraightSize()) {
            return false;
        }

        // Sort cards using the rankSorter (descending order: Ace -> King -> ...)
        cards.sort(Deck.rankSorter());

        // Check if Ace is part of the straight
        if (cards.get(0).getRank() == Ranks.ACE) {
            // Check for "Ace as high" straight
            boolean aceHighStraight = true;
            for (int i = 1; i < cards.size() - 1 && i < GameManager.getCurrentDeck().getMinStraightSize() - 1; i++) {
                if (cards.get(i).getRank().ordinal() != cards.get(i + 1).getRank().ordinal() + 1) {
                    aceHighStraight = false;
                    break;
                }
            }

            // Check for "Ace as low" straight (Ace-2-3-4-5)
            boolean aceLowStraight = true;
            if (cards.get(cards.size() - 1).getRank() == Ranks.TWO) {
                for (int i = 1; i < cards.size() - 1 && i < GameManager.getCurrentDeck().getMinStraightSize() - 1; i++) {
                    if (cards.get(i).getRank().ordinal() != cards.get(i + 1).getRank().ordinal() + 1) {
                        aceLowStraight = false;
                        break;
                    }
                }
            } else {
                aceLowStraight = false;
            }

            return aceHighStraight || aceLowStraight;
        } else {
            // General straight check for non-Ace scenarios
            for (int i = 0; i < cards.size() - 1 && i < GameManager.getCurrentDeck().getMinStraightSize() - 1; i++) {
                if (cards.get(i).getRank().ordinal() != cards.get(i + 1).getRank().ordinal() + 1) {
                    return false;
                }
            }
        }
        return true;
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

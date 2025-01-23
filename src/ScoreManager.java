import cards.Card;
import decks.Deck;
import enums.PokerHands;
import enums.Ranks;
import enums.Suits;

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

    public static boolean containsThreeOfAKind(ArrayList<Card> cards, Ranks rank) {
        if(cards.size() < 3) return false;
        cards.sort(Deck.rankSorter());
        for (int i = 0; i < cards.size() - 2; i++) {
            if(cards.get(i).getRank() == rank) {
                if(cards.get(i).getRank() == cards.get(i + 1).getRank() && cards.get(i).getRank() == cards.get(i + 2).getRank()) {
                    return true;
                }
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
    public static boolean containsPair(ArrayList<Card> cards, Ranks rank) {
        if(cards.size() < 2) return false;
        cards.sort(Deck.rankSorter());
        for(int i = 0; i < cards.size() - 1; i++) {
            if(cards.get(i).getRank() == rank) {
                if(cards.get(i).getRank() == cards.get(i+1).getRank())
                    return true;
            }
        }
        return false;
    }

    public static boolean containsTwoPair(ArrayList<Card> cards) {
        // Two Pair: Two sets of pairs
        if (cards.size() < 4) return false;
        ArrayList<Card> copy = new ArrayList<>(cards);
        copy.sort(Deck.rankSorter());

        int pairs = 0;
        for (int i = 0; i < copy.size() - 1; i++) {
            if (copy.get(i).getRank() == copy.get(i + 1).getRank()) {
                pairs++;
                i++; // Skip the next card in the pair
            }
        }
        return pairs >= 2;
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
        if(cards.size() < GameManager.getCurrentDeck().getMinStraightSize())
            return false;
        for (int i = 0; i < cards.size() - 1; i++) {
            if(cards.get(i).getSuit() != cards.get(i + 1).getSuit())
                return false;
        }
        return true;
    }
    public static boolean containsFullHouse(ArrayList<Card> cards) {
        if (cards.size() < 5) return false;

        // Create a copy of the cards to avoid modifying the original list
        ArrayList<Card> copy = new ArrayList<>(cards);
        copy.sort(Deck.rankSorter()); // Sort the cards by rank (descending)

        // Check for three-of-a-kind
        Ranks threeOfAKindRank = null;
        for (int i = 0; i < copy.size() - 2; i++) {
            if (copy.get(i).getRank() == copy.get(i + 1).getRank() &&
                    copy.get(i).getRank() == copy.get(i + 2).getRank()) {
                threeOfAKindRank = copy.get(i).getRank();
                // Remove the three-of-a-kind cards from the copy
                copy.remove(i);
                copy.remove(i);
                copy.remove(i);
                break;
            }
        }

        // If no three-of-a-kind was found, it's not a full house
        if (threeOfAKindRank == null) return false;

        // Check for a pair in the remaining cards
        for (int i = 0; i < copy.size() - 1; i++) {
            if (copy.get(i).getRank() == copy.get(i + 1).getRank()) {
                return true; // Found a full house
            }
        }

        // No pair found
        return false;
    }

    public static boolean containsRoyalFlush(ArrayList<Card> cards) {
        // Royal Flush: A, K, Q, J, 10 of the same suit
        if (!containsFlush(cards)) return false;
        cards.sort(Deck.rankSorter());
        Suits suit = cards.get(0).getSuit();
        ArrayList<Ranks> royalRanks = new ArrayList<>(List.of(Ranks.ACE, Ranks.KING, Ranks.QUEEN, Ranks.JACK, Ranks.TEN));

        for (Card card : cards) {
            if (card.getSuit() == suit && royalRanks.contains(card.getRank())) {
                royalRanks.remove(card.getRank());
            }
        }
        return royalRanks.isEmpty();
    }
    public static boolean containsStraightFlush(ArrayList<Card> cards) {
        return containsFlush(cards) && containsStraight(cards);
    }
    public static boolean containsFlushFive(ArrayList<Card> cards) {
        return containsFiveOfAKind(cards) && containsFlush(cards);
    }
    public static boolean containsFiveOfAKind(ArrayList<Card> cards) {
        // Five of a Kind: Five cards of the same rank
        if (cards.size() < 5) return false;
        for (Ranks rank : Ranks.values()) {
            int count = 0;
            for (Card card : cards) {
                if (card.getRank() == rank) count++;
                if (count == 5) return true;
            }
        }
        return false;
    }
    public static boolean containsFlushHouse(ArrayList<Card> cards) {
        return containsFlush(cards) && containsFullHouse(cards);
    }

    public static PokerHands getBestHand(ArrayList<Card> cards) {
        if(containsFlushFive(cards))
            return PokerHands.FLUSH_FIVE;
        if(containsFlushHouse(cards))
            return PokerHands.FLUSH_HOUSE;
        if(containsFiveOfAKind(cards))
            return PokerHands.FIVE_OF_A_KIND;
        if(containsRoyalFlush(cards))
            return PokerHands.ROYAL_FLUSH;
        if(containsStraightFlush(cards))
            return PokerHands.STRAIGHT_FLUSH;
        if(containsFourOfAKind(cards))
            return PokerHands.FOUR_OF_A_KIND;
        if(containsFullHouse(cards))
            return PokerHands.FULL_HOUSE;
        if(containsFlush(cards))
            return PokerHands.FLUSH;
        if(containsStraight(cards))
            return PokerHands.STRAIGHT;
        if(containsThreeOfAKind(cards))
            return PokerHands.THREE_OF_A_KIND;
        if(containsTwoPair(cards))
            return PokerHands.TWO_PAIRS;
        if(containsPair(cards))
            return PokerHands.PAIR;
        return PokerHands.HIGH_CARD;
    }
}

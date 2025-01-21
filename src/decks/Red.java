package decks;

import cards.Card;
import enums.Ranks;
import enums.Suits;

import java.util.ArrayList;
import java.util.Random;

public class Red extends Deck{
    public Red() {
        super(3, 4, 8);
    }

    @Override
    protected void generateDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deckCards.add(new Card(Ranks.values()[j], Suits.values()[i]));
            }
        }
        System.out.println(deckCards);
    }
}

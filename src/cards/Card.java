package cards;

import enums.*;
public class Card{
    private Ranks rank;
    private Suits suit;
    private Editions edition;
    private Seals seal;
    private Enhancements enhancement;
    private long chips;

    public Card(Ranks rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
        this.edition = Editions.BASE;
        this.seal = null;
        this.enhancement = null;
        this.chips = rank.getValue();
    }

    public Card(Card c) {
        this.rank = c.getRank();
        this.suit = c.getSuit();
        this.edition = c.getEdition();
        this.seal = c.getSeal();
        this.enhancement = c.getEnhancement();
        this.chips = c.chips;
    }

    public Ranks getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public Editions getEdition() {
        return edition;
    }

    public void setEdition(Editions edition) {
        this.edition = edition;
    }

    public Seals getSeal() {
        return seal;
    }

    public void setSeal(Seals seal) {
        this.seal = seal;
    }

    public Enhancements getEnhancement() {
        return enhancement;
    }

    public void setEnhancement(Enhancements enhancement) {
        this.enhancement = enhancement;
    }

    public void setRank(Ranks rank) {
        this.rank = rank;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return switch (this.rank) {
            case ACE -> "A";
            case JACK -> "J";
            case QUEEN -> "Q";
            case KING -> "K";
            default -> this.rank.ordinal() + 2;
        } + switch(this.suit) {
            case CLUBS -> "♣";
            case HEARTS -> "♥";
            case DIAMONDS -> "♦";
            case SPADES -> "♠";
        };
    }
}

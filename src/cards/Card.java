package cards;

import enums.*;
public class Card{
    private Ranks rank;
    private Suits suit;
    private Editions edition;
    private Seals seal;
    private Enhancements enhancement;

    public Card(Ranks rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
        this.edition = Editions.BASE;
        this.seal = null;
        this.enhancement = null;
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

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}

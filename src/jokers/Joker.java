package jokers;

import enums.Editions;
import enums.Rarity;
import enums.Stickers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Joker {
    private final String name;
    private BigInteger extraPlusChips;
    private BigInteger extraPlusMultiplier;
    private BigDecimal extraTimesMultiplier;
    private Editions edition;
    private final Stickers sticker;
    private Rarity rarity;

    public Joker(String name, BigInteger extraPlusChips, BigInteger extraPlusMultiplier, BigDecimal extraTimesMultiplier, Editions edition, Stickers sticker, Rarity rarity) {
        this.name = name;
        this.extraPlusChips = extraPlusChips;
        this.extraPlusMultiplier = extraPlusMultiplier;
        this.extraTimesMultiplier = extraTimesMultiplier;
        this.edition = edition;
        this.sticker = sticker;
        this.rarity = rarity;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public BigInteger getExtraPlusChips() {
        return extraPlusChips;
    }

    public BigInteger getExtraPlusMultiplier() {
        return extraPlusMultiplier;
    }

    public BigDecimal getExtraTimesMultiplier() {
        return extraTimesMultiplier;
    }

    public Editions getEdition() {
        return edition;
    }

    public Stickers getSticker() {
        return sticker;
    }

    public Rarity getRarity() {
        return rarity;
    }

    // Setter methods
    public void setExtraPlusChips(BigInteger extraPlusChips) {
        this.extraPlusChips = extraPlusChips;
    }

    public void setExtraPlusMultiplier(BigInteger extraPlusMultiplier) {
        this.extraPlusMultiplier = extraPlusMultiplier;
    }

    public void setExtraTimesMultiplier(BigDecimal extraTimesMultiplier) {
        this.extraTimesMultiplier = extraTimesMultiplier;
    }

    public void setEdition(Editions edition) {
        this.edition = edition;
    }
}

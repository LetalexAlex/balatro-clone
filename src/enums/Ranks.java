package enums;

public enum Ranks {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    public int getValue() {
        return switch (this) {
            case ACE -> 11;
            case JACK, QUEEN, KING -> 10;
            default -> ordinal() + 2;
        };
    }
}



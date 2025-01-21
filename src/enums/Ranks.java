package enums;

public enum Ranks {
    ACE,
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
    KING;

    public int getValue() {
        return switch (this) {
            case ACE -> 11;
            case JACK, QUEEN, KING -> 10;
            default -> ordinal() + 1;
        };
    }
}



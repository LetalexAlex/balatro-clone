package outputUtils;

/**
 * The ColorCode enum represents various ANSI escape codes for text colors, background colors, and text styles.
 * These codes can be used to format console output in terminals that support ANSI escape sequences.
 */
public enum ColorCode {
    /** Resets all color and style formatting */
    RESET("\u001B[0m"),

    // Regular Colors
    /** Black text color */
    BLACK("\u001B[30m"),
    /** Red text color */
    RED("\u001B[31m"),
    /** Green text color */
    GREEN("\u001B[32m"),
    /** Yellow text color */
    YELLOW("\u001B[33m"),
    /** Blue text color */
    BLUE("\u001B[34m"),
    /** Purple text color */
    PURPLE("\u001B[35m"),
    /** Cyan text color */
    CYAN("\u001B[36m"),
    /** White text color */
    WHITE("\u001B[37m"),

    // Bold Colors
    /** Bold black text color */
    BLACK_BOLD("\u001B[1;30m"),
    /** Bold red text color */
    RED_BOLD("\u001B[1;31m"),
    /** Bold green text color */
    GREEN_BOLD("\u001B[1;32m"),
    /** Bold yellow text color */
    YELLOW_BOLD("\u001B[1;33m"),
    /** Bold blue text color */
    BLUE_BOLD("\u001B[1;34m"),
    /** Bold purple text color */
    PURPLE_BOLD("\u001B[1;35m"),
    /** Bold cyan text color */
    CYAN_BOLD("\u001B[1;36m"),
    /** Bold white text color */
    WHITE_BOLD("\u001B[1;37m"),

    // Underline Colors
    /** Underlined black text color */
    BLACK_UNDERLINED("\u001B[4;30m"),
    /** Underlined red text color */
    RED_UNDERLINED("\u001B[4;31m"),
    /** Underlined green text color */
    GREEN_UNDERLINED("\u001B[4;32m"),
    /** Underlined yellow text color */
    YELLOW_UNDERLINED("\u001B[4;33m"),
    /** Underlined blue text color */
    BLUE_UNDERLINED("\u001B[4;34m"),
    /** Underlined purple text color */
    PURPLE_UNDERLINED("\u001B[4;35m"),
    /** Underlined cyan text color */
    CYAN_UNDERLINED("\u001B[4;36m"),
    /** Underlined white text color */
    WHITE_UNDERLINED("\u001B[4;37m"),

    // Background Colors
    /** Black background color */
    BG_BLACK("\u001B[40m"),
    /** Red background color */
    BG_RED("\u001B[41m"),
    /** Green background color */
    BG_GREEN("\u001B[42m"),
    /** Yellow background color */
    BG_YELLOW("\u001B[43m"),
    /** Blue background color */
    BG_BLUE("\u001B[44m"),
    /** Purple background color */
    BG_PURPLE("\u001B[45m"),
    /** Cyan background color */
    BG_CYAN("\u001B[46m"),
    /** White background color */
    BG_WHITE("\u001B[47m"),

    // High Intensity Colors
    /** Bright black text color */
    BLACK_BRIGHT("\u001B[90m"),
    /** Bright red text color */
    RED_BRIGHT("\u001B[91m"),
    /** Bright green text color */
    GREEN_BRIGHT("\u001B[92m"),
    /** Bright yellow text color */
    YELLOW_BRIGHT("\u001B[93m"),
    /** Bright blue text color */
    BLUE_BRIGHT("\u001B[94m"),
    /** Bright purple text color */
    PURPLE_BRIGHT("\u001B[95m"),
    /** Bright cyan text color */
    CYAN_BRIGHT("\u001B[96m"),
    /** Bright white text color */
    WHITE_BRIGHT("\u001B[97m"),

    // High Intensity Background Colors
    /** Bright black background color */
    BG_BLACK_BRIGHT("\u001B[100m"),
    /** Bright red background color */
    BG_RED_BRIGHT("\u001B[101m"),
    /** Bright green background color */
    BG_GREEN_BRIGHT("\u001B[102m"),
    /** Bright yellow background color */
    BG_YELLOW_BRIGHT("\u001B[103m"),
    /** Bright blue background color */
    BG_BLUE_BRIGHT("\u001B[104m"),
    /** Bright purple background color */
    BG_PURPLE_BRIGHT("\u001B[105m"),
    /** Bright cyan background color */
    BG_CYAN_BRIGHT("\u001B[106m"),
    /** Bright white background color */
    BG_WHITE_BRIGHT("\u001B[107m"),

    // Text Styles
    /** Bold text style */
    BOLD("\u001B[1m"),
    /** Underlined text style */
    UNDERLINE("\u001B[4m"),
    /** Blinking text style (may not work in all terminals) */
    BLINK("\u001B[5m"),
    /** Reversed text style (swaps foreground and background colors) */
    REVERSED("\u001B[7m"),
    /** Invisible text style (text color same as background) */
    INVISIBLE("\u001B[8m"),

    // Custom Colors
    /** Gold text color */
    GOLD("\u001B[38;2;255;215;0m"),
    /** Silver text color */
    SILVER("\u001B[38;2;192;192;192m"),
    /** Beige text color */
    BEIGE("\u001B[38;2;245;245;220m"),
    /** Teal text color */
    TEAL("\u001B[38;2;0;128;128m"),
    /** Maroon text color */
    MAROON("\u001B[38;2;128;0;0m"),
    /** Navy text color */
    NAVY("\u001B[38;2;0;0;128m"),
    /** Olive text color */
    OLIVE("\u001B[38;2;128;128;0m"),
    /** Coral text color */
    CORAL("\u001B[38;2;255;127;80m"),
    /** Salmon text color */
    SALMON("\u001B[38;2;250;128;114m"),
    /** Turquoise text color */
    TURQUOISE("\u001B[38;2;64;224;208m"),
    /** Violet text color */
    VIOLET("\u001B[38;2;238;130;238m"),
    /** Indigo text color */
    INDIGO("\u001B[38;2;75;0;130m"),
    /** Crimson text color */
    CRIMSON("\u001B[38;2;220;20;60m"),
    /** Lime text color */
    LIME("\u001B[38;2;0;255;0m"),
    /** Magenta text color */
    MAGENTA("\u001B[38;2;255;0;255m"),
    /** Plum text color */
    PLUM("\u001B[38;2;221;160;221m"),
    /** Khaki text color */
    KHAKI("\u001B[38;2;240;230;140m"),

    // Custom Background Colors
    /** Gold background color */
    BG_GOLD("\u001B[48;2;255;215;0m"),
    /** Silver background color */
    BG_SILVER("\u001B[48;2;192;192;192m"),
    /** Beige background color */
    BG_BEIGE("\u001B[48;2;245;245;220m"),
    /** Teal background color */
    BG_TEAL("\u001B[48;2;0;128;128m"),
    /** Maroon background color */
    BG_MAROON("\u001B[48;2;128;0;0m"),
    /** Navy background color */
    BG_NAVY("\u001B[48;2;0;0;128m"),
    /** Olive background color */
    BG_OLIVE("\u001B[48;2;128;128;0m"),
    /** Coral background color */
    BG_CORAL("\u001B[48;2;255;127;80m"),
    /** Salmon background color */
    BG_SALMON("\u001B[48;2;250;128;114m"),
    /** Turquoise background color */
    BG_TURQUOISE("\u001B[48;2;64;224;208m"),
    /** Violet background color */
    BG_VIOLET("\u001B[48;2;238;130;238m"),
    /** Indigo background color */
    BG_INDIGO("\u001B[48;2;75;0;130m"),
    /** Crimson background color */
    BG_CRIMSON("\u001B[48;2;220;20;60m"),
    /** Lime background color */
    BG_LIME("\u001B[48;2;0;255;0m"),
    /** Magenta background color */
    BG_MAGENTA("\u001B[48;2;255;0;255m"),
    /** Plum background color */
    BG_PLUM("\u001B[48;2;221;160;221m"),
    /** Khaki background color */
    BG_KHAKI("\u001B[48;2;240;230;140m");

    private final String code;

    /**
     * Constructs a ColorCode enum constant with the specified ANSI escape code.
     *
     * @param code The ANSI escape code for the color or style.
     */
    ColorCode(String code) {
        this.code = code;
    }

    /**
     * Returns the ANSI escape code associated with this ColorCode.
     *
     * @return The ANSI escape code as a String.
     */
    public String getCode() {
        return code;
    }
}

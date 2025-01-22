package outputUtils;

/**
 * The Colored class provides utility methods for printing colored and formatted text to the console.
 * It uses ANSI escape codes to apply various text colors, background colors, and styles.
 */
public class Colored {

    /**
     * Prints the given text in the specified color.
     *
     * @param text  The text to be printed.
     * @param color The color to apply to the text.
     */
    public static void print(String text, ColorCode color) {
        System.out.print(color.getCode() + text + ColorCode.RESET.getCode());
    }

    /**
     * Prints the given text in the specified color, followed by a new line.
     *
     * @param text  The text to be printed.
     * @param color The color to apply to the text.
     */
    public static void println(String text, ColorCode color) {
        System.out.println(color.getCode() + text + ColorCode.RESET.getCode());
    }

    /**
     * Prints the given text with the specified text color and background color.
     *
     * @param text    The text to be printed.
     * @param color   The color to apply to the text.
     * @param bgColor The background color to apply.
     */
    public static void print(String text, ColorCode color, ColorCode bgColor) {
        System.out.print(color.getCode() + bgColor.getCode() + text + ColorCode.RESET.getCode());
    }

    /**
     * Prints the given text with the specified text color and background color, followed by a new line.
     *
     * @param text    The text to be printed.
     * @param color   The color to apply to the text.
     * @param bgColor The background color to apply.
     */
    public static void println(String text, ColorCode color, ColorCode bgColor) {
        System.out.println(color.getCode() + bgColor.getCode() + text + ColorCode.RESET.getCode());
    }

    /**
     * Formats the given text with the specified color codes and styles.
     *
     * @param text    The text to be formatted.
     * @param formats The color codes and styles to apply.
     * @return A string with the formatted text.
     */
    public static String format(String text, ColorCode... formats) {
        StringBuilder formatted = new StringBuilder();
        for (ColorCode format : formats) {
            formatted.append(format.getCode());
        }
        formatted.append(text).append(ColorCode.RESET.getCode());
        return formatted.toString();
    }

    /**
     * Prints the given text with each character in a different color, creating a rainbow effect.
     *
     * @param text The text to be printed in rainbow colors.
     */
    public static void printRainbow(String text) {
        ColorCode[] colors = {ColorCode.RED, ColorCode.YELLOW, ColorCode.GREEN, ColorCode.CYAN, ColorCode.BLUE, ColorCode.PURPLE};
        for (int i = 0; i < text.length(); i++) {
            System.out.print(colors[i % colors.length].getCode() + text.charAt(i));
        }
        System.out.print(ColorCode.RESET.getCode());
    }

    /**
     * Prints the given text with a color gradient from the start color to the end color.
     *
     * @param text       The text to be printed with a gradient.
     * @param startColor The starting color of the gradient.
     * @param endColor   The ending color of the gradient.
     */
    public static void printGradient(String text, ColorCode startColor, ColorCode endColor) {
        int[] startRGB = getRGB(startColor);
        int[] endRGB = getRGB(endColor);
        int steps = text.length() - 1;

        for (int i = 0; i < text.length(); i++) {
            int r = startRGB[0] + (endRGB[0] - startRGB[0]) * i / steps;
            int g = startRGB[1] + (endRGB[1] - startRGB[1]) * i / steps;
            int b = startRGB[2] + (endRGB[2] - startRGB[2]) * i / steps;
            System.out.print("\u001B[38;2;" + r + ";" + g + ";" + b + "m" + text.charAt(i));
        }
        System.out.print(ColorCode.RESET.getCode());
    }

    /**
     * Prints the given text in the specified color with a blinking effect.
     * Note: The blinking effect may not work in all terminals.
     *
     * @param text  The text to be printed with a blinking effect.
     * @param color The color to apply to the text.
     */
    public static void printBlink(String text, ColorCode color) {
        System.out.print(ColorCode.BLINK.getCode() + color.getCode() + text + ColorCode.RESET.getCode());
    }

    /**
     * Prints the given text inside a colored box.
     *
     * @param text        The text to be printed inside the box.
     * @param borderColor The color of the box border.
     * @param textColor   The color of the text inside the box.
     */
    public static void printBox(String text, ColorCode borderColor, ColorCode textColor) {
        int width = text.length() + 4;
        String horizontalBorder = "+" + "-".repeat(width - 2) + "+";

        println(horizontalBorder, borderColor);
        println("| " + format(text, textColor) + " |", borderColor);
        println(horizontalBorder, borderColor);
    }

    /**
     * Helper method to extract RGB values from a ColorCode enum constant.
     *
     * @param color The ColorCode to extract RGB values from.
     * @return An array of three integers representing the RGB values.
     */
    private static int[] getRGB(ColorCode color) {
        String code = color.getCode();
        if (code.startsWith("\u001B[38;2;")) {
            String[] parts = code.substring(7, code.length() - 1).split(";");
            return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])};
        }
        return new int[]{255, 255, 255}; // Default to white if not an RGB color
    }
}

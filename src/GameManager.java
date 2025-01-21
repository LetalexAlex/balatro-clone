public class GameManager {

    // TUTTI I METODI E ATTRIBUTI DI QUESTA CLASSE DEVONO ESSERE STATICI.

    private static long seed;
    private static boolean isGameOngoing;

    public static void setSeed(long newSeed) {
        if(isGameOngoing) {
            throw new RuntimeException("Cannot change seed while game is running.");
        }
        seed = newSeed;
    }
}

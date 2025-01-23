package events;

public class test {
    public static void main(String[] args) {
        // Create an EventSource to manage subscribers and trigger events
        EventSource eventSource = new EventSource();

        // Register an EventListener that runs a method based on the event type
        eventSource.registerListener(event -> {
            switch (event.getType()) {
                case BUY_NORMAL_PACK:
                    handleBuyNormalPack(event.getMessage());
                    break;
                case USE_TAROT_MAGICIAN:
                    handleUseTarotMagician(event.getMessage());
                    break;
                case DRAW_CARDS:
                    handleDrawCards(event.getMessage());
                    break;
                default:
                    handleUnknownEvent(event.getType(), event.getMessage());
                    break;
            }
            System.out.println("===============================");
        });

        eventSource.triggerEvent(EventType.BUY_NORMAL_PACK, "User purchased normal pack");
        eventSource.triggerEvent(EventType.USE_TAROT_MAGICIAN, "Activated the Magician tarot card");
        eventSource.triggerEvent(EventType.DRAW_CARDS, "3 cards drawn from the deck");
    }

    private static void handleBuyNormalPack(String message) {
        System.out.println("Handling BUY_NORMAL_PACK event");
        System.out.println("Message: " + message);
    }

    private static void handleUseTarotMagician(String message) {
        System.out.println("Handling USE_TAROT_MAGICIAN event");
        System.out.println("Message: " + message);
    }

    private static void handleDrawCards(String message) {
        System.out.println("Handling DRAW_CARDS event");
        System.out.println("Message: " + message);
    }

    private static void handleUnknownEvent(EventType type, String message) {
        System.out.println("Handling unknown event: " + type);
        System.out.println("Message: " + message);
    }
}

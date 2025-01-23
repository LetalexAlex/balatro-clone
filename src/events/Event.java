
package events;

/**
 * Represents an event with a specific type and a descriptive message.
 * This class encapsulates the event's type and message, allowing you to retrieve
 * each component as needed. It is designed to be easily extended with additional
 * fields or functionality if required.
 */
public class Event {

    /**
     * The type of this event.
     */
    private final EventType type;

    /**
     * The message describing this event.
     */
    private final String message;

    /**
     * Constructs an Event instance with the specified type and message.
     *
     * @param type
     *        The type of the event, indicating the context or category.
     * @param message
     *        A string representing further details about the event.
     */
    public Event(EventType type, String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * Retrieves the event type, which can be used to categorize or handle
     * the event accordingly.
     *
     * @return the event's type
     */
    public EventType getType() {
        return type;
    }

    /**
     * Retrieves the message associated with this event, providing additional
     * details or context.
     *
     * @return the message describing the event
     */
    public String getMessage() {
        return message;
    }
}

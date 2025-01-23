package events;

/**
 * Provides a mechanism for objects to be notified of an event's occurrence.
 * Implementing classes can register this interface and define custom
 * behaviors when specific events are received, enabling flexible and
 * reusable event-handling structures.
 */
public interface EventListener {

    /**
     * Called whenever an event is triggered, providing access to all
     * relevant details of the event so that an appropriate response
     * can be enacted.
     *
     * @param event
     *        The event object containing information required for handling.
     */
    void onEvent(Event event);
}

package events;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a source of events, allowing the registration and removal of
 * event listeners, and dispatching events to ensure all registered listeners
 * receive notifications.
 */
public class EventSource {

    /**
     * Maintains a collection of listeners that are notified whenever
     * an event is triggered.
     */
    private final List<EventListener> listeners = new ArrayList<>();

    /**
     * Registers a listener to receive events dispatched from this source.
     *
     * @param listener
     *        The listener to be added to the notification list.
     */
    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes a previously registered listener, preventing it from
     * receiving future event notifications.
     *
     * @param listener
     *        The listener to be removed from the notification list.
     */
    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    /**
     * Triggers an event of the specified type with the provided message,
     * notifying all registered listeners by invoking their <code>onEvent</code>
     * method.
     *
     * @param type
     *        The type of the event being triggered.
     * @param message
     *        The message providing additional details about the event.
     */
    public void triggerEvent(EventType type, String message) {
        Event event = new Event(type, message);
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}

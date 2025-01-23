package events;

import java.util.ArrayList;
import java.util.List;

public class EventSource {
    private final List<EventListener> listeners = new ArrayList<>();

    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void triggerEvent(EventType type, String message) {
        Event event = new Event(type, message);
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}

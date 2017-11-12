package events;

import java.util.PriorityQueue;

/**
 * The event manager manages the event by executing them in the correct order
 * (based on their date).
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class EventManager {

    /**
     * The current date allows the event manager to execute the events in the
     * correct order.
     */
    private long currentDate;

    /**
     * The events are stored in a priority queue based on their date.
     */
    private final PriorityQueue<Event> events;

    /**
     * Initiate the events priority queue.
     */
    public EventManager() {
        currentDate = 0;
        events = new PriorityQueue<>();
    }

    /**
     * Add an event to the manager, that will be executed afterwards.
     *
     * @param e The event to add.
     */
    public void addEvent(Event e) {
        events.add(e);
    }

    /**
     * Increment the current date and executes all the event until the current
     * date.
     */
    public void next() {
        currentDate++;
        while (!isFinished() && events.peek().getDate() <= currentDate) {
            events.poll().execute();
        }
    }

    /**
     * Tells if all the event have been executed.
     *
     * @return true if all the event have been executed
     */
    public boolean isFinished() {
        return events.size() == 0;
    }

    /**
     * Restart the event manager.
     */
    public void restart() {
        events.clear();
        currentDate = 0;
    }
}

package events;

/**
 * An Event that can be created to execute an action at a given date.
 *
 * @author Baptiste Rigondaud
 *
 */
public abstract class Event implements Comparable<Event> {

    /**
     * The event's date.
     */
    private long date;

    /**
     * Initiate the event with a given date.
     *
     * @param date
     */
    public Event(long date) {
        this.date = date;
    }

    /**
     * Getter for the event's date
     *
     * @return The event's date.
     */
    public long getDate() {
        return this.date;
    }

    /**
     * Executes an action related to the event.
     */
    public abstract void execute();

    /**
     * Compares two events based on their date.
     *
     * @return 1, 0 or -1 to create an order between events
     * @throws NullPointerException if the event to compare with is null.
     */
    @Override
    public int compareTo(Event e) {
        if (e == null) {
            throw new NullPointerException("Can't compare with null pointer.");
        }
        if (e.getDate() < this.date) {
            return 1;
        } else if (e.getDate() > this.date) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Two events are equal if they happen at the same time.
     *
     * @return true if the two event happen at the same time.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Event == false) {
            return false;
        }
        Event e = (Event) o;
        return this.date == e.getDate();
    }
}

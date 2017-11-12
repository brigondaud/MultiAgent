package events;

/**
 * Represents a message event (wording example).
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class MessageEvent extends Event {

    /**
     * The message to print when the event fires.
     */
    private final String message;

    /**
     * Constructor {date, message}.
     *
     * @param date The date to fire the event
     * @param message The message to print
     */
    public MessageEvent(int date, String message) {
        super(date);
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println(this.getDate() + this.message);
    }
}

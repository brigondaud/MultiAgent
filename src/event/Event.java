package event;

/**
 * An Event that can be created to execute an action at a given date.
 * 
 * @author Baptiste Rigondaud
 *
 */
public abstract class Event {
	/**
	 * The event's date.
	 */
	private long date;

	/**
	 * Init the event with a given date.
	 * 
	 * @param date
	 */
	public Event(long date) {
		this.date = date;
	}
	
	/**
	 * Getter for the event's date
	 * @return The event's date.
	 */
	public long getDate() {
		return this.date;
	}
	
	/**
	 * Executes an action related to the event.
	 */
	public abstract void execute();
}

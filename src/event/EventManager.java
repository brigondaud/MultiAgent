package event;

import event.Event;

/**
 * The event manager manages the event by executing them in the correct order
 * (based on their date).
 * 
 * @author Baptiste Rigondaud
 *
 */
public class EventManager {

	/**
	 * The current date allows the event manager to execute the events in the
	 * correct order.
	 */
	private long currentDate;

	/**
	 * Add an event to the manager, that will be executed afterwards.
	 * 
	 * @param e
	 *            The event to add.
	 */
	public void addEvent(Event e) {
		// TODO
	}

	/**
	 * Increment the current date and executes all the event until the current date.
	 */
	public void next() {
		// TODO
	}

	/**
	 * Tells if all the event have been executed.
	 * 
	 * @return true if all the event have been executed
	 */
	public boolean isFinished() {
		// TODO
		return true;
	}
	
	/**
	 * Restart the event manager.
	 */
	public void restart() {
		//TODO
	}
}

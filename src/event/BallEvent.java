package event;

import java.awt.Point;
import balls.Balls;

/**
 * The ball event corresponds to the movement a group of balls. It initiates the
 * movement and create a new movement in the movement manager to simulate a
 * continuous movement.
 * 
 * @author Baptiste Rigondaud
 *
 */
public class BallEvent extends Event {

	/**
	 * The balls on which the event can be executed.
	 */
	private Balls balls;

	/**
	 * The velocity that controls the balls movement.
	 */
	private Point velocity;

	/**
	 * To simulate the continuous movement, the event needs to add a new event in
	 * the event manager that executes it.
	 */
	private EventManager events;

	/**
	 * Init the event with a date and the balls on which the event can execute the
	 * movement, with a given velocity.
	 * 
	 * @param date
	 * @param events
	 * @param balls
	 * @param velocity
	 */
	public BallEvent(long date, EventManager events, Balls balls, Point velocity) {
		super(date);
		this.balls = balls;
		this.velocity = velocity;
		this.events = events;
	}

	/**
	 * The execution of the event translate the balls and generate another event to
	 * simulate the continuous movement.
	 */
	@Override
	public void execute() {
		balls.translate(velocity.x, velocity.y);
		events.addEvent(new BallEvent(getDate() + 1, events, balls, velocity));
	}

}

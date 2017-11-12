package events;

import java.awt.Point;
import balls.Balls;

/**
 * The ball event corresponds to the movement a group of balls. It initiates the
 * movement and create a new movement in the movement manager to simulate a
 * continuous movement.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class BallEvent extends Event {

    /**
     * The balls on which the event can be executed.
     */
    private final Balls balls;

    /**
     * The velocity that controls the balls movement.
     */
    private final Point velocity;

    /**
     * To simulate the continuous movement, the event needs to add a new event
     * in the event manager that executes it.
     */
    private final EventManager events;

    /**
     * Initiate the event with a date and the balls on which the event can
     * execute the movement, with a given velocity.
     *
     * @param date The date to fire the event.
     * @param events The events to simulate a continuous movement.
     * @param balls The balls associated with the event.
     * @param velocity The velocity of the balls.
     */
    public BallEvent(long date, EventManager events, Balls balls, Point velocity) {
        super(date);

        this.balls = balls;
        this.velocity = velocity;
        this.events = events;
    }

    /**
     * The execution of the event translates the balls and generates another
     * event to simulate the continuous movement.
     */
    @Override
    public void execute() {
        balls.translate(velocity.x, velocity.y);
        events.addEvent(new BallEvent(getDate() + 1, events, balls, velocity));
    }
}

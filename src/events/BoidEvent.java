package events;

import boids.BoidGroup;
import boids.BoidSystem;

/**
 * Represents an event an a boid group to update the whole group. Each time a
 * BoidEvent is fired, all rules are applied to boids.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class BoidEvent extends Event {

    /**
     * The system in which the event will fire. This reference allows recursion
     * to create events.
     */
    private final BoidSystem system;

    /**
     * The flock to update when the event fires.
     */
    private final BoidGroup flock;

    /**
     * Constructor of the event {date, system, flock}. Neither the system nor
     * the flock can be null.
     *
     * @param date The date to fire the event.
     * @param system The system to register the next event.
     * @param flock The flock to update.
     */
    public BoidEvent(long date, BoidSystem system, BoidGroup flock) {
        super(date);

        if (flock == null || system == null) {
            throw new IllegalArgumentException("No null flock in events.");
        }

        this.flock = flock;
        this.system = system;
    }

    @Override
    public void execute() {
        this.flock.update();
        BoidEvent nextEvent = new BoidEvent(this.getDate() + this.flock.getDelay(), system, flock);

        this.system.getEvents().addEvent(nextEvent);
    }
}

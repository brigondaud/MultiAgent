package balls;

import gui.*;
import java.awt.Point;
import events.EventManager;
import events.BallEvent;

/**
 * Behavior for the simulator of balls.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class BallsSimulator implements Simulable {

    /**
     * The group of balls to simulate.
     */
    private final Balls balls;

    /**
     * The balls velocity.
     */
    private final Point velocity;

    /**
     * The GUI in which the simulator is set.
     */
    private final GUISimulator gui;

    /**
     * The event manager that registers the balls movement.
     */
    private final EventManager events;

    /**
     * Constructor {gui}.
     * 
     * @param gui   The graphical user interface of balls.
     */
    public BallsSimulator(GUISimulator gui) {
        this.gui = gui;
        this.velocity = new Point(5, 5);
        this.balls = new BouncingBalls(10, velocity, gui.getPanelWidth(), gui.getPanelHeight());
        
        for (int i = 0; i < balls.getBallNumber(); i++) {
            gui.addGraphicalElement(balls.getGraphicalBall(i));
        }
        
        this.events = new EventManager();
        
        // Adds an initial event to make the balls move when the simulation starts.
        events.addEvent(new BallEvent(1, events, balls, velocity));
    }

    /**
     * Moves all the balls with random translation coordinates
     */
    @Override
    public void next() {
        events.next();
    }

    /**
     * Restart the simulation by moving balls back to the beginning
     */
    @Override
    public void restart() {
        balls.reInit();
        gui.reset();
        for (int i = 0; i < balls.getBallNumber(); i++) {
            gui.addGraphicalElement(balls.getGraphicalBall(i));
        }
    }

}

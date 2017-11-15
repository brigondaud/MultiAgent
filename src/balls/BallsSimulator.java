package balls;

import gui.*;
import java.awt.Point;
import events.EventManager;
import events.BallEvent;
import java.awt.Color;
import systems.AbstractSystem;

/**
 * Behavior for the simulator of balls.
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
 * @version 1.0
 */
public class BallsSimulator extends AbstractSystem {

    /**
     * The group of balls to simulate.
     */
    private final Balls balls;

    /**
     * The balls velocity.
     */
    private final Point velocity;

    /**
     * Constructor {gui}.
     */
    public BallsSimulator() {
        this.gui = new GUISimulator(500, 500, Color.BLACK);

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

    @Override
    public GUISimulator simulate() {
        this.gui.setSimulable(this);

        return this.gui;
    }
}

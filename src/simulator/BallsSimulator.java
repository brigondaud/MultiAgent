package simulator;

import gui.*;
import balls.Balls;
import balls.BouncingBalls;
import java.awt.Point;

/**
 * Behavior for the simulator of balls
 * 
 * @author Baptiste Rigondaud
 *
 */
public class BallsSimulator implements Simulable {

	/**
	 * The group of balls to simulate.
	 */
	private Balls balls;

	/**
	 * The balls velocity.
	 */
	private Point velocity;

	/**
	 * The GUI in which the simulator is set.
	 */
	private GUISimulator gui;

	public BallsSimulator(GUISimulator gui) {
		this.gui = gui;
		this.velocity = new Point(5, 5);
		this.balls = new BouncingBalls(10, velocity, gui.getPanelWidth(), gui.getPanelHeight());
		for (int i = 0; i < balls.getBallNumber(); i++) {
			gui.addGraphicalElement(balls.getGraphicalBall(i));
		}
	}

	/**
	 * Moves all the balls with random translation coordinates
	 */
	@Override
	public void next() {
		balls.translate(velocity.x, velocity.y);
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

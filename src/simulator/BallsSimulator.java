package simulator;

import gui.*;
import balls.Balls;
//import java.util.Random;
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

	public BallsSimulator(GUISimulator gui) {
		this.velocity = new Point(1, 7);
		this.balls = new Balls(10, velocity, gui.getPanelWidth(), gui.getPanelHeight());
		for (Oval ball: balls.getGraphicalBalls()) {
			gui.addGraphicalElement(ball);
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
	}

}

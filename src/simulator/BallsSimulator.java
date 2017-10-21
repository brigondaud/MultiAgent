package simulator;

import gui.*;
import balls.GraphicalBalls;
import java.util.Random;

/**
 * Behavior for the simulator of balls
 * 
 * @author Baptiste Rigondaud
 *
 */
public class BallsSimulator implements Simulable {

	private GraphicalBalls balls;

	public BallsSimulator(GUISimulator gui) {
		this.balls = new GraphicalBalls(100, gui.getPanelWidth(), gui.getPanelHeight());
		gui.addGraphicalElement(balls);
	}

	/**
	 * Moves all the balls with random translation coordinates
	 */
	@Override
	public void next() {
		Random randomMovement = new Random();
		balls.translate(randomMovement.nextInt(2), randomMovement.nextInt(2));
	}

	/**
	 * Restart the simulation by moving balls back to the beginning
	 */
	@Override
	public void restart() {
		balls.reInit();
	}

}

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
		this.balls = new GraphicalBalls(1, gui.getPanelWidth(), gui.getPanelHeight());
		gui.addGraphicalElement(balls);
	}

	/**
	 * Moves all the balls with random translation coordinates
	 */
	@Override
	public void next() {
		Random randomMovement = new Random();
		int rand = randomMovement.nextInt(2) + 1;
		balls.translate(rand, rand);
	}

	/**
	 * Restart the simulation by moving balls back to the beginning
	 */
	@Override
	public void restart() {
		balls.reInit();
	}

}

package simulator;

import gui.*;
import balls.Balls;
import java.util.Random;

/**
 * Behavior for the simulator of balls
 * 
 * @author Baptiste Rigondaud
 *
 */
public class BallsSimulator implements Simulable {

	private Balls balls;

	public BallsSimulator() {
		this.balls = new Balls(5);
	}

	/**
	 * Moving all the balls with random translation coordinates
	 */
	@Override
	public void next() {
		Random randomMovement = new Random();
		balls.translate(randomMovement.nextInt(2), randomMovement.nextInt(2));
		System.out.println(balls);
	}

	/**
	 * Restart the simulation by moving balls back to the beginning
	 */
	@Override
	public void restart() {
		balls.reInit();
	}

}

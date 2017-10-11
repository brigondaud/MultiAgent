package balls;

import java.awt.Point;
import java.util.Random;

/**
 * Vector of Balls represented by Points
 * 
 * @author Baptiste Rigondaud
 *
 */
public class Balls {
	/**
	 * The balls are represented as Points
	 */
	protected Point[] balls;
	/**
	 * The init position for each ball
	 */
	private Point[] initBalls;

	/**
	 * Creates ballNumber balls with random coordinates between maxWidth and
	 * maxHeight
	 * 
	 * @param ballNumber
	 * @param maxWidth
	 * @param maxHeight
	 */
	public Balls(int ballNumber, int maxWidth, int maxHeight) {
		this.balls = new Point[ballNumber];
		this.initBalls = new Point[ballNumber];
		Random coordsGenerator = new Random();
		for (int i = 0; i < balls.length; i++) {
			int initX = coordsGenerator.nextInt(maxWidth);
			int initY = coordsGenerator.nextInt(maxHeight);
			this.balls[i] = new Point(initX, initY);
			this.initBalls[i] = new Point(initX, initY);
		}
	}

	/**
	 * Prints all the balls as a couple of coordinates
	 */
	@Override
	public String toString() {
		String ballsString = "";
		for (Point ball : balls) {
			ballsString += ball.toString();
		}
		return ballsString;
	}

	/**
	 * Moves all the balls along the x axis and y axis from dx and dy
	 * 
	 * @param dx
	 * @param dy
	 */
	public void translate(int dx, int dy) {
		for (Point ball : balls) {
			ball.translate(dx, dy);
			// TODO: in a setter, verify that x and y are still positive ?
		}
	}

	/**
	 * Reset the positions of the balls
	 */
	public void reInit() {
		for (int i = 0; i < balls.length; i++) {
			balls[i].move(initBalls[i].x, initBalls[i].y);
		}
	}
}

package Balls;

import java.awt.Point;
import java.util.Random;

/**
 * Vector of Balls represented by Points
 * 
 * @author Baptiste Rigondaud
 *
 */
public class Balls {
	private Point[] balls;

	/**
	 * Creates balls with random coordinates
	 * 
	 * @param ball_number
	 *            The number of balls created
	 */
	public Balls(int ball_number) {
		this.balls = new Point[ball_number];
		Random coordsGenerator = new Random();
		for (int i = 0; i < balls.length; i++) {
			this.balls[i] = new Point(coordsGenerator.nextInt(200), coordsGenerator.nextInt(200));
		}
	}

	/**
	 * Prints all the balls as a couple of coordinates
	 */
	@Override
	public String toString() {
		String ballsString = "";
		for (Point ball : balls) {
			ballsString += "(" + ball.getX() + ", " + ball.getY() + ")\n";
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

	}
}

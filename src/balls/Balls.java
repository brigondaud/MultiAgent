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
	private Point[] balls;
	/**
	 * The init position for each ball
	 */
	private Point[] init_balls;

	/**
	 * Creates balls with random coordinates
	 * 
	 * @param ball_number
	 *            The number of balls created
	 */
	public Balls(int ball_number) {
		this.balls = new Point[ball_number];
		this.init_balls = new Point[ball_number];
		Random coordsGenerator = new Random();
		for (int i = 0; i < balls.length; i++) {
			int init_x = coordsGenerator.nextInt(200);
			int init_y = coordsGenerator.nextInt(200);
			this.balls[i] = new Point(init_x, init_y);
			this.init_balls[i] = new Point(init_x, init_y);
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
			balls[i].move((int) init_balls[i].getX(), (int) init_balls[i].getY());
		}
	}
}

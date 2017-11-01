package balls;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;
import gui.GraphicalElement;
import gui.Oval;

/**
 * Vector of Balls represented by Points
 * 
 * @author Baptiste Rigondaud
 *
 */

public class Balls implements GraphicalElement {

	/**
	 * The different graphic options to draw the balls.
	 */
	private static Color drawColor = Color.decode("#B5A3C4");
	private static Color fillColor = Color.decode("#4D8FAC");
	private static int ballSize = 15;

	/**
	 * The balls are represented as Points.
	 */
	private Point[] balls;
	/**
	 * The init position for each ball.
	 */
	private Point[] initBalls;

	/**
	 * A same group of balls has the same velocity.
	 */
	private Point ballsVelocity;

	/**
	 * The graphic elements that represents the balls on screen.
	 */
	private Oval[] graphicalBalls;

	/**
	 * Creates ballNumber balls with random coordinates between maxWidth and
	 * maxHeight.
	 * 
	 * @param ballNumber
	 * @param maxWidth
	 * @param maxHeight
	 */
	public Balls(int ballNumber, Point initVelocity, int maxWidth, int maxHeight) {
		this.balls = new Point[ballNumber];
		this.initBalls = new Point[ballNumber];
		this.ballsVelocity = new Point(initVelocity);
		this.graphicalBalls = new Oval[ballNumber];

		// Generating the balls ranomly
		Random coordsGenerator = new Random();
		for (int i = 0; i < balls.length; i++) {
			int initX = coordsGenerator.nextInt(maxWidth);
			int initY = coordsGenerator.nextInt(maxHeight);
			this.initBalls[i] = new Point(initX, initY);
			this.balls[i] = new Point(initX, initY);
			this.graphicalBalls[i] = new Oval(initX, initY, drawColor, fillColor, ballSize);
		}
	}

	/**
	 * Getter for the graphical balls.
	 * 
	 * @return The graphical balls to register them in the GUI.
	 */
	public Oval[] getGraphicalBalls() {
		return this.graphicalBalls;
	}

	/**
	 * Prints all the balls as a couple of coordinates.
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
	 * Moves all the balls along the x axis and y axis from dx and dy.
	 * 
	 * @param dx
	 * @param dy
	 */
	public void translate(int dx, int dy) {
		for (int i = 0; i < balls.length; i++) {
			balls[i].translate(dx, dy);
			graphicalBalls[i].translate(dx, dy);
		}
	}

	/**
	 * Reset the positions of the balls.
	 */
	public void reInit() {
		for (int i = 0; i < balls.length; i++) {
			balls[i].move(initBalls[i].x, initBalls[i].y);
			graphicalBalls[i] = new Oval(initBalls[i].x, initBalls[i].y, drawColor, fillColor, ballSize);
		}
	}

	/**
	 * Draws the ball on the gui.
	 */
	@Override
	public void paint(Graphics2D g2d) {
		for (Oval graphicalBall : graphicalBalls) {
			graphicalBall.paint(g2d);
		}

	}
}

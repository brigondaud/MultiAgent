package balls;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.GraphicalElement;
import gui.Oval;

/**
 * Balls that can be dawn on a GUISimulator
 * 
 * @author Baptiste Rigondaud
 *
 */
public class GraphicalBalls extends Balls implements GraphicalElement {

	private static Color drawColor = Color.decode("#B5A3C4");
	private static Color fillColor = Color.decode("#4D8FAC");
	private static int ballSize = 15;
	private Oval[] graphicalBalls;

	/**
	 * Creates balls and their graphical element
	 * 
	 * @param ballsNumber
	 *            The number of balls to create
	 */
	public GraphicalBalls(int ballsNumber, int panelWidth, int panelHeight) {
		super(ballsNumber, panelWidth, panelHeight);
		graphicalBalls = new Oval[ballsNumber];
		for (int i = 0; i < balls.length; i++) {
			graphicalBalls[i] = new Oval(balls[i].x, balls[i].y, drawColor, fillColor, ballSize);
		}
	}

	/**
	 * Paints the balls on a surface
	 * 
	 * @param g2d
	 *            The surface to draw on
	 */
	public void paint(Graphics2D g2d) {
		for (Oval graphicalBall : graphicalBalls) {
			graphicalBall.paint(g2d);
		}
	}

	/**
	 * Translates the balls and the graphicalBalls
	 */
	@Override
	public void translate(int dx, int dy) {
		super.translate(dx, dy);
		for (Oval graphicalBall : graphicalBalls) {
			graphicalBall.translate(dx, dy);
		}
	}

	/**
	 * Reset the position of the graphical balls
	 */
	@Override
	public void reInit() {
		super.reInit();
		for (int i = 0; i < balls.length; i++) {
			graphicalBalls[i] = new Oval(balls[i].x, balls[i].y, drawColor, fillColor, ballSize);
		}
	}

}

package balls;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;
import gui.GraphicalElement;
import gui.Oval;

/**
 * Vector of Balls represented by Points. This modelisation fits with the
 * wording.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class Balls implements GraphicalElement {

    /**
     * (Graphic option). The color inside the balls.
     */
    private final static Color drawColor = Color.decode("#B5A3C4");

    /**
     * (Graphic option). The color outside the balls.
     */
    private final static Color fillColor = Color.decode("#4D8FAC");

    /**
     * (Graphic option). The size of the balls.
     */
    private final static int ballSize = 15;

    /**
     * The number of balls.
     */
    private final int ballNumber;

    /**
     * The balls are represented as Points.
     */
    private final Point[] balls;

    /**
     * The initial position for each ball.
     */
    private final Point[] initBalls;

    /**
     * The graphic elements that represents the balls on screen.
     */
    private final Oval[] graphicalBalls;

    /**
     * Creates ballNumber balls with random coordinates between maxWidth and
     * maxHeight.
     *
     * @param ballNumber The number of balls.
     * @param initVelocity The initial velocity of balls.
     * @param maxWidth The maximum X to generate a ball.
     * @param maxHeight The maximum Y to generate a ball.
     */
    public Balls(int ballNumber, Point initVelocity, int maxWidth, int maxHeight) {
        this.ballNumber = ballNumber;
        this.balls = new Point[ballNumber];
        this.initBalls = new Point[ballNumber];
        this.graphicalBalls = new Oval[ballNumber];

        // Generating the balls randomly
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
     * Getter for numberBall.
     *
     * @return the number of ball
     */
    public int getBallNumber() {
        return this.ballNumber;
    }

    /**
     * Getter for the i ball.
     *
     * @param i The i^th request balled.
     * @return The i ball.
     * @throws IllegalArgumentException if i is not a correct index
     */
    public Point getBall(int i) {
        if (i > balls.length) {
            throw new IllegalArgumentException("index out of range");
        }
        return this.balls[i];
    }

    /**
     * Getter for the i graphical ball.
     *
     * @param i The i^th request graphical ball.
     * @return The i graphical ball to register them in the GUI.
     * @throws IllegalArgumentException if i is not a correct index
     */
    public Oval getGraphicalBall(int i) {
        if (i > balls.length) {
            throw new IllegalArgumentException("index out of range");
        }
        return this.graphicalBalls[i];
    }

    /**
     * Print all the balls as a couple of coordinates.
     *
     * @return The stringified version of the object.
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
     * Move all the balls along the x axis and y axis from dx and dy.
     *
     * @param dx The translation along the x-axis.
     * @param dy The translation along the y-axis.
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
     * Draw the ball on the GUI.
     *
     * @param g2d The graphical instance in which to paint balls.
     */
    @Override
    public void paint(Graphics2D g2d) {
        for (Oval graphicalBall : graphicalBalls) {
            graphicalBall.paint(g2d);
        }

    }
}

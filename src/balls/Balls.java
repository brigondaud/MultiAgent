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
     * The number of balls.
     */
    private int ballNumber;

    /**
     * The balls are represented as Points.
     */
    private Point[] balls;

    /**
     * The initial position for each ball.
     */
    private Point[] initBalls;

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
     * Draws the ball on the GUI.
     */
    @Override
    public void paint(Graphics2D g2d) {
        for (Oval graphicalBall : graphicalBalls) {
            graphicalBall.paint(g2d);
        }

    }
}

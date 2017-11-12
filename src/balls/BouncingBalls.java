package balls;

import java.awt.Point;

/**
 * Possible directions for the balls.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
enum Direction {

    TOPLEFT,
    TOPRIGHT,
    BOTTOMLEFT,
    BOTTOMRIGHT,
    STILL
};

/**
 * Vector of bouncing balls.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class BouncingBalls extends Balls {

    /**
     * Each ball direction.
     */
    private final Direction[] ballsDirections;

    /**
     * The initial direction of every ball.
     */
    private final Direction initDirection;

    /**
     * The maximum width where the balls can go.
     */
    private final int maxWidth;

    /**
     * The maximum height where the ball can go.
     */
    private final int maxHeight;

    /**
     * Constructor of bouncing balls.
     *
     * @param ballNumber The number of balls in this simulation.
     * @param initVelocity The initial velocity of bouncing balls.
     * @param maxWidth The maximum X to draw a ball.
     * @param maxHeight The maximum Y to draw a ball.
     */
    public BouncingBalls(int ballNumber, Point initVelocity, int maxWidth, int maxHeight) {
        super(ballNumber, initVelocity, maxWidth, maxHeight);

        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        ballsDirections = new Direction[ballNumber];

        // Looking for the initial direction
        if (initVelocity.x > 0 && initVelocity.y > 0) {
            initDirection = Direction.BOTTOMRIGHT;
        } else if (initVelocity.x > 0 && initVelocity.y < 0) {
            initDirection = Direction.TOPRIGHT;
        } else if (initVelocity.x < 0 && initVelocity.y > 0) {
            initDirection = Direction.BOTTOMLEFT;
        } else if (initVelocity.x < 0 && initVelocity.y < 0) {
            initDirection = Direction.TOPLEFT;
        } else {
            initDirection = Direction.STILL;
        }

        for (int i = 0; i < ballNumber; i++) {
            ballsDirections[i] = initDirection;
        }
    }

    /**
     * Restart all the balls and give them the initial direction.
     */
    @Override
    public void reInit() {
        super.reInit();
        for (int i = 0; i < ballsDirections.length; i++) {
            ballsDirections[i] = initDirection;
        }
    }

    /**
     * Prints all the balls as a couple of coordinates.
     *
     * @return The stringified version of the bouncing balls.
     */
    @Override
    public String toString() {
        String ballsString = "";
        for (int i = 0; i < getBallNumber(); i++) {
            ballsString += "\n" + getBall(i).toString() + "Direction: " + ballsDirections[i].toString();
        }
        return ballsString;
    }

    /**
     * Check for a bounce before moving the ball.
     */
    @Override
    public void translate(int dx, int dy) {
        int initDx = dx;
        int initDy = dy;
        for (int i = 0; i < getBallNumber(); i++) {
            Point ball = getBall(i);
            Direction dir = ballsDirections[i];
            switch (dir) { // Looking for the possible bounces for each direction
                case TOPLEFT:
                    dx = -dx;
                    dy = -dy;
                    if ((ball.x + dx) < 0) { // Left side bounce
                        ballsDirections[i] = Direction.TOPRIGHT;
                        dx = -dx;
                    } else if (ball.y + dy < 0) { // Top side bounce
                        ballsDirections[i] = Direction.BOTTOMLEFT;
                        dy = -dy;
                    }
                    break;
                case TOPRIGHT:
                    dy = -dy;
                    if ((ball.y + dy) < 0) { // Top side bounce
                        ballsDirections[i] = Direction.BOTTOMRIGHT;
                        dy = -dy;
                    } else if (ball.x + dx > maxWidth) { // Right side bounce
                        ballsDirections[i] = Direction.TOPLEFT;
                        dx = -dx;
                    }
                    break;
                case BOTTOMLEFT:
                    dx = -dx;
                    if ((ball.x + dx) < 0) { // Left side bounce
                        ballsDirections[i] = Direction.BOTTOMRIGHT;
                        dx = -dx;
                    } else if (ball.y + dy > maxHeight) { // Bottom side bounce
                        ballsDirections[i] = Direction.TOPLEFT;
                        dy = -dy;
                    }
                    break;
                case BOTTOMRIGHT:
                    if ((ball.x + dx) > maxWidth) { // Right side bounce
                        ballsDirections[i] = Direction.BOTTOMLEFT;
                        dx = -dx;
                    } else if (ball.y + dy > maxHeight) { // Bottom side bounce
                        ballsDirections[i] = Direction.TOPRIGHT;
                        dy = -dy;
                    }
                    break;
                case STILL:
                    break;
            }

            ball.translate(dx, dy);
            getGraphicalBall(i).translate(dx, dy);

            // Reset the move for the next ball
            dx = initDx;
            dy = initDy;
        }
    }
}

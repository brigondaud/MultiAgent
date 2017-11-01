package balls;

import java.awt.Point;

/**
 * Vector of bouncing balls
 * 
 * @author Baptiste Rigondaud
 *
 */
enum Direction {
	TOPLEFT, TOPRIGHT, BOTTOMLEFT, BOTTOMRIGHT, STILL
};

public class BouncingBalls extends Balls {

	/**
	 * Each ball direction.
	 */
	private Direction[] ballsDirections;

	/**
	 * The initial direction of every ball.
	 */
	private Direction initDirection;
	
	/**
	 * The maximum width where the balls can go.
	 */
	private int maxWidth;
	
	/**
	 * The maximum height where the ball can go.
	 */
	private int maxHeight;

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
	 * Check for a bounce before moving the ball.
	 */
	@Override
	public void translate(int dx, int dy) {
		for (int i = 0; i < getBalls().length; i++) {
			Point ball = getBalls()[i];
			Direction dir = ballsDirections[i];
			switch (dir) {
			case TOPLEFT:
				dx = -dx;
				dy = -dy;
				if ((ball.getX() - dx) <= 0) {
					ballsDirections[i] = Direction.TOPRIGHT;
					dy = -dy;
				} else {
					ballsDirections[i] = Direction.BOTTOMLEFT;
					dx = -dx;
				}
				break;
			case TOPRIGHT:
				dy = -dy;
				if ((ball.getX() - dx) <= 0) {
					ballsDirections[i] = Direction.BOTTOMRIGHT;
					dy = -dy;
				} else {
					ballsDirections[i] = Direction.TOPLEFT;
					dx = -dx;
				}
				break;
			case BOTTOMLEFT:
				dx = -dx;
				if ((ball.getY() - dy) <= 0) {
					ballsDirections[i] = Direction.BOTTOMRIGHT;
					dx = -dx;
				} else {
					ballsDirections[i] = Direction.TOPLEFT;
					dy = -dy;
				}
				break;
			case BOTTOMRIGHT:
				if ((ball.getX() + dx) >= maxWidth) {
					ballsDirections[i] = Direction.BOTTOMLEFT;
					dx = -dx;
				} else {
					ballsDirections[i] = Direction.TOPRIGHT;
					dy = -dy;
				}
				break;
			case STILL:
				break;
			}
			getBalls()[i].translate(dx, dy);
			getGraphicalBalls()[i].translate(dx, dy);
		}
	}
}
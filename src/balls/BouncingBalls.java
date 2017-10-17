package balls;

import java.awt.Point;

/**
 * Vector of bouncing balls
 * 
 * @author Baptiste Rigondaud
 *
 */
enum Direction {
	TOPLEFT, TOPRIGHT, BOTTOMLEFT, BOTTOMRIGHT
};

public class BouncingBalls extends Balls {
	private Direction[] ballsDirections;
	private int maxWidth;

	public BouncingBalls(int ballNumber, int maxWidth, int maxHeight) {
		super(ballNumber, maxWidth, maxHeight);
		ballsDirections = new Direction[ballNumber];
		this.maxWidth = maxWidth;
		for (int i = 0; i < balls.length; i++) {
			ballsDirections[i] = Direction.TOPLEFT;
		}
	}

	@Override
	public void reInit() {
		super.reInit();
		for (int i = 0; i < ballsDirections.length; i++) {
			ballsDirections[i] = Direction.TOPLEFT;
		}
	}

	@Override
	public void translate(int dx, int dy) {
		for (int i = 0; i < balls.length; i++) {
			Point ball = balls[i];
			Direction dir = ballsDirections[i];
			switch (dir) {
			case TOPLEFT:
				dx = -dx;
				dy = -dy;
				System.out.println("(" + dx + ", " + dy +")");
				if ((ball.getX() - dx) <= 0) {
					ballsDirections[i] = Direction.BOTTOMLEFT;
					dy = -dy;
				} else {
					ballsDirections[i] = Direction.TOPRIGHT;
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
			}
			balls[i].translate(dx, dy);
		}
	}
}

package test;

import balls.Balls;

/**
 * Test file for the Balls.Balls class
 *
 * @author Team 22 in Teide
 */
public class TestBalls {

    public static void main(String[] args) {
        Balls balls = new Balls(100, null, 200, 200);
        System.out.println(balls);

        Balls singleBall = new Balls(1, null, 100, 100);
        System.out.println("Single ball: " + singleBall);
        singleBall.translate(1, 2);
        System.out.println("Translating the ball from +1, +2 : " + singleBall);
        singleBall.reInit();
        System.out.println("Reset the singleBall position: " + singleBall);
    }
}

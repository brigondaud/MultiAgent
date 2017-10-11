package test;

import gui.GUISimulator;
import java.awt.Color;
import simulator.BallsSimulator;

/**
 * Test for the ball simulation
 * 
 * @author Baptiste Rigondaud
 *
 */
public class TestBallsSimulator {
	public static void main(String[] args) {
		GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
		gui.setSimulable(new BallsSimulator(gui));
	}
}

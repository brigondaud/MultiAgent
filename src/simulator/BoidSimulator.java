package simulator;

import java.util.ArrayList;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;

import gui.Simulable;
import gui.GUISimulator;
import boids.Boid;
import boids.Rule;

/**
 * A boids simulator, making boids evolve in a 2D environment with given rules.
 * 
 * @author Baptiste Rigondaud
 *
 */
public class BoidSimulator implements Simulable {

	/**
	 * The boids which are simulated
	 */
	private ArrayList<Boid> boids;

	/**
	 * The rules applied to the boids
	 */
	private ArrayList<Rule> rules;

	public BoidSimulator(GUISimulator gui, int boidsNumber) {
		this.boids = new ArrayList<Boid>();
		for (int i = 0; i < boidsNumber; i++) {
			this.boids.add(new Boid(gui.getPanelWidth(), gui.getPanelHeight()));
		}

		// TODO: add rules
		this.rules = new ArrayList<Rule>();
	}

	@Override
	public void next() {
		for (Boid boid : boids) {
			for (Rule rule : rules) {
				Point2D.Float VelocityModifier = new Point2D.Float();
				VelocityModifier = rule.applyRule(boid);
				boid.getVelocity().setLocation(VelocityModifier.getX() + boid.getVelocity().getX(),
						VelocityModifier.getY() + boid.getVelocity().getY());
			}
		}
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub

	}

}

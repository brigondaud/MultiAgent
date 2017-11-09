package boids;

import java.awt.geom.Point2D;

import boids.Boid;

/**
 * Rule represents a regulation which can be applied to a boid.
 * 
 * @author Baptiste Rigondaud
 *
 */
public abstract class Rule {
	/**
	 * The application of a rule returns a Point that can be added to the boid's
	 * velocity.
	 * 
	 * @param boid The boid on which the rule will be computed.
	 * @return
	 */
	public abstract Point2D.Float applyRule(Boid boid);
}